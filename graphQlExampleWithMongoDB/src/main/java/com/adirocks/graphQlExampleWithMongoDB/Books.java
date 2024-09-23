package com.adirocks.graphQlExampleWithMongoDB;

import io.leangen.graphql.annotations.GraphQLQuery;

import java.util.ArrayList;
import java.util.List;

public class Books {

    @GraphQLQuery
    private String id;

    @GraphQLQuery
    private String name;

    @GraphQLQuery
    private String desc;

    @GraphQLQuery
    private List<Author> authors = new ArrayList<>();

    public Books(String id, String name, String desc, List<Author> authors) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.authors = authors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }


}
