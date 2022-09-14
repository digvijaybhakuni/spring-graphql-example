package com.example.graphql;

import com.example.graphql.domain.Author;
import com.example.graphql.domain.Post;
import com.example.graphql.repo.AuthorRepo;
import com.example.graphql.repo.PostRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}


//	@Bean
	public CommandLineRunner runner(PostRepo postRepo, AuthorRepo authorRepo) {
		return args -> {

			Author joe = authorRepo.save(new Author(null, "Joe"));
			Author jack = authorRepo.save(new Author(null, "Jack"));

			Date now = new Date();
			Post post1 = postRepo.save(new Post(null, "Best Programming Language", "1 Java, 2 Python, 3 Typescript", joe, List.of("java", "python", "typescript")));
			Post post2 = postRepo.save(new Post(null, "Docker Alternative", "1 podman, 2 kubernetes, 3 cri-o", joe, List.of("docker", "podman", "k8s", "cri-o")));
			Post post3 = postRepo.save(new Post(null, "Best Cloud Provider", "1 AWS, 2 GCP, 3 Azure", jack, List.of("aws", "gcp", "azure")));
//			Post post1 = postRepo.save(new Post(null, "Best Programming Language", "1 Java, 2 Python, 3 Typescript", joe, List.of("java", "python", "typescript")));

		};
	}

}
