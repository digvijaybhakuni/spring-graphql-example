package com.example.graphql.repo;

import com.example.graphql.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface AuthorRepo extends CrudRepository<Author, Long> {
}
