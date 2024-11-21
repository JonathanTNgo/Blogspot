package com.blogspot.blogspot.Post;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = "post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public List<Post> getPosts() {
        return postService.getPosts();
    }
    

    @PostMapping()
    public ResponseEntity<?> postPost(@RequestBody Post post) {
        // System.out.println(post);
        try {
            postService.addNewPost(post);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post successfully created.");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Could not create post, a post on that date already exists.");
        }
    }

    @DeleteMapping(path = "{postDate}")
    public ResponseEntity<?> deletePost(@PathVariable("postDate") LocalDate date) {
        try {
            postService.deletePost(date);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post successfully deleted.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Could not delete post.");
        }
    }
    
}
