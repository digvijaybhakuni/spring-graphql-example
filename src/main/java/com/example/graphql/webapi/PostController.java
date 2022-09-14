package com.example.graphql.webapi;

import com.example.graphql.domain.Post;
import com.example.graphql.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostRepo postRepo;

    @QueryMapping("posts")
    public Iterable<Post> getPosts(){
        return postRepo.findAll();
    }
    @QueryMapping("post")
    public Post getPosts(@Argument("id") Long id){
        return postRepo.findById(id).orElseThrow(IllegalArgumentException::new);
    }
    @QueryMapping
    public String greeting() {
        return "Hello World!";

    }

    @QueryMapping("postByAuthor")
    public Iterable<Post> getPostByAuthor(@Argument("id") Long authorId) {
       return postRepo.findByAuthorId(authorId);
    }
}
