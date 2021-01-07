package com.sample.project.services;

import com.sample.project.dto.PostDto;
import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    PostDto findById(long id);
    void save(PostDto postDto);
    void deleteById(long theId);
    List<PostDto> getAllPostByUserId(long id);
}
