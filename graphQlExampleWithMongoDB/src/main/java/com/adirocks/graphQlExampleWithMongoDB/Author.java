package com.adirocks.graphQlExampleWithMongoDB;

import io.leangen.graphql.annotations.GraphQLQuery;

public class Author {

    @GraphQLQuery
    private String id;

    @GraphQLQuery
    private String name;

    @GraphQLQuery
    private int age;

    public Author(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
