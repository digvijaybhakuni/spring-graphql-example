package com.example.graphql.repo;

import com.example.graphql.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface PostRepo extends CrudRepository<Post, Long> {
    Iterable<Post> findByAuthorId(Long authorId);
}
