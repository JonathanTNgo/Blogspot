package com.blogspot.blogspot.Post;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PostConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(PostRepository repository) {
        return args -> {
        };
    }
}
