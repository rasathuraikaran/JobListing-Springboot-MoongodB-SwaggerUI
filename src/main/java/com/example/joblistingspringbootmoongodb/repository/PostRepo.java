package com.example.joblistingspringbootmoongodb.repository;

import com.example.joblistingspringbootmoongodb.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepo  extends MongoRepository<Post,String> {



}
