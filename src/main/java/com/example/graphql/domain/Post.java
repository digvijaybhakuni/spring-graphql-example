package com.example.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    private Author author;
    @ElementCollection
    @CollectionTable(name="tags", joinColumns=@JoinColumn(name="post_id"))
    @Column(name="tags")
    private Collection<String> tags = new ArrayList<>();
//    @CreatedDate
//    private Date createOn;
}
