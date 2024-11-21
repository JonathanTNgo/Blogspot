package com.blogspot.blogspot.Post;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {
    
    // @Query("SELECT s FROM Post s WHERE s.date = ?1")
    Optional<Post> findPostByDate(LocalDate date);

    
}
