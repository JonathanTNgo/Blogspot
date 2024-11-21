package com.blogspot.blogspot.Post;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table
public class Post {

    @Id
    @SequenceGenerator(
        name = "post_sequence",
        sequenceName = "post_sequence",
        allocationSize = 1

    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "post_sequence"
    )
    private Long id;
    @Column(unique = true)
    private LocalDate date;
    private String title;
    private String body;

    public Post() {
    }

    public Post(Long id, String title, String body) {
        this.id = id;
        this.date = LocalDate.now();
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body) {
        this.date = LocalDate.now();
        this.title = title;
        this.body = body;
    }

    public void set_id(Long id) {
        this.id = id;
    }

    public Long get_id() {
        return id;
    }

    public void set_date(LocalDate date) {
        this.date = date;
    }

    public LocalDate get_date() {
        return date;
    }

    public void set_body(String body) {
        this.body = body;
    }

    public String get_body() {
        return body;
    }

    public void set_title(String title) {
        this.title = title;
    }

    public String get_title() {
        return title;
    }

    @Override
    public String toString() {
        return "{ Post ID = " + id + 
            "\nDate = " + date +
            "\nTitle = " + title +
            "\nBody = " + body + " }";
    }
}
