package com.springmongodb.exemplemongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.springmongodb.exemplemongodb.entities.Post;
import com.springmongodb.exemplemongodb.repository.PostRepository;
import com.springmongodb.exemplemongodb.services.exceptions.NotFoundObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new NotFoundObj("Objeto não encontrado!"));
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
