package com.example.graphql.webapi;

import com.example.graphql.domain.Author;
import com.example.graphql.repo.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepo authorRepo;

    @QueryMapping
    public Iterable<Author> authors() {
        return authorRepo.findAll();
    }


    @QueryMapping
    public Author author(@Argument("id") Long id) {
        return authorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Author Id"));
    }

}
