package com.adirocks.graphQlExampleWithMongoDB;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
@GraphQLApi
public class BooksService {

    private  List<Books> bookList = new ArrayList<>();

    @PostConstruct
    void loadData(){
        Author a1 = new Author("AUTH_1","Aman",25);
        Author a2 = new Author("AUTH_2","Ankit",22);
        Author a3 = new Author("AUTH_3","Shivam",20);
        List<Author> b1List = new ArrayList<>();
        List<Author> b2List = new ArrayList<>();
        List<Author> b3List = new ArrayList<>();
        b1List.add(a1);
        b1List.add(a2);
        b2List.add(a2);
        b2List.add(a3);
        b3List.add(a1);
        b3List.add(a3);
        Books b1 = new Books("BOOK_1", "Book1", "Physics Book", b1List);
        Books b2 = new Books("BOOK_2", "Book2", "Chemistry Book", b2List);
        Books b3 = new Books("BOOK_3", "Book3", "Biology Book", b3List);
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
    }

    @GraphQLQuery(name = "book")
    public Books findBook(@GraphQLArgument(name = "id") Long id){
        return bookList.stream().filter(b->b.getId().equals(id)).findFirst().orElse(null);
    }

    @GraphQLQuery(name = "books")
    public List<Books> findBooks(){
        return bookList;
    }

    @GraphQLMutation(name = "addBook")
    public Books addBook(@GraphQLArgument(name = "book") Books book) {
        bookList.add(book);
        return book;
    }

    @GraphQLMutation(name = "deleteBook")
    public String deleteBook(@GraphQLArgument(name = "id") Long id) {
        Iterator it = bookList.iterator();
        while(it.hasNext()){
            Books b = (Books) it.next();
            if(b.getId().equals(id)){
                bookList.remove(b);
                return b.toString();
            }
        }
        return "No Books Found";
    }


}
