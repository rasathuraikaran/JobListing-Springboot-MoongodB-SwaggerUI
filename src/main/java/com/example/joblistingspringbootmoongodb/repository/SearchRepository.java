package com.example.joblistingspringbootmoongodb.repository;

import com.example.joblistingspringbootmoongodb.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
}
