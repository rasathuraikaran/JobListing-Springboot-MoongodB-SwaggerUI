package com.example.joblistingspringbootmoongodb;

import com.example.joblistingspringbootmoongodb.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo  extends MongoRepository<Post,String> {



}
