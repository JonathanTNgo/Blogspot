package com.blogspot.blogspot.Post;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Returns list of all posts
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    // Checks for unique date and saves post to database
    public void addNewPost(Post post) {
        // Temp fix
        post.set_date(LocalDate.now());
        postRepository.save(post);
    }  

    public void deletePost(LocalDate date) {
        Optional<Post> exists = postRepository.findPostByDate(date);
        if (exists.isPresent()) {
            // throw new IllegalStateException("Post on date: " + id + " does not exist.");
            postRepository.deleteById(exists.get().get_id());
        } else {
            throw new IllegalStateException("Post on date: " + date + " does not exist.");
        }   
    }
}
