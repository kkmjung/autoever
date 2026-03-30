package com.example.post.service;

import com.example.post.model.Post;
import com.example.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
      return postRepository.findAll();
    };

    public Post getPostById(Long id){
        return postRepository.findById(id);
    }

    public void createPost(Post post){
        if(post.getTitle() == null || post.getTitle().trim().isEmpty()){
            throw new IllegalArgumentException("제목은 필수 입력 사항입니다.");
        }
        postRepository.save(post);
    };

    public void updatePost(Long id, Post post){
        postRepository.update(id,post);
    };

    public void deletePost(Long id){
        postRepository.delete(id);
    }

}
