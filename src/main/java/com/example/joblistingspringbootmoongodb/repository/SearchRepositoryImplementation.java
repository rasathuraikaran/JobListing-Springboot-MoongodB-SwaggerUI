package com.example.joblistingspringbootmoongodb.repository;

import com.example.joblistingspringbootmoongodb.model.Post;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class SearchRepositoryImplementation implements SearchRepository {
    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Post> findByText(String text) {

        MongoDatabase database = mongoClient.getDatabase("karan");
        MongoCollection<Document> collection = database.getCollection("JobPost");


        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));

        final List<Post> post = new ArrayList<>();
result.forEach(document -> post.add(mongoConverter.read(Post.class,document)));

        return post;
    }
}
