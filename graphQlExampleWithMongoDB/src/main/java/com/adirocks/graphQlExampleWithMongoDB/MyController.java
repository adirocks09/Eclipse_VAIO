package com.adirocks.graphQlExampleWithMongoDB;

import graphql.GraphQL;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/myGraphQL")
public class MyController {

    @Autowired
    private BooksService bookService;

    @Autowired
    private GraphQL graphQl;

    @RequestMapping("/test")
    public Map<String,String> testApi(){
          return Collections.singletonMap("name","Aditya Anand !!!");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/testGraphQlApis")
    public Object testGraphQlApis(@RequestBody String query){
        return graphQl.execute(query);
    }

}
