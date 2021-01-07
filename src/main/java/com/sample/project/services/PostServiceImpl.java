package com.sample.project.services;

import com.sample.project.dto.PostDto;
import com.sample.project.exception.PostNotFoundException;
import com.sample.project.model.Post;
import com.sample.project.model.User;
import com.sample.project.repositories.PostRepository;
import com.sample.project.repositories.UserRepository;
import com.sample.project.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private Helper helper;

    @Override
    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    @Override
    public PostDto findById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        return mapFromPostToDto(post);
    }

    @Override
    public List<PostDto> getAllPostByUserId(long id){
        List<Post> posts = postRepository.findPosts(id);
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    @Override
    public void save(PostDto postDto) {
        Post post = mapFromDtoToPost(postDto);
        User user = helper.userInfo();
        post.setUser(user);
        post.setCreateDateOn(Instant.now());
        post.setUpdateDateOn(Instant.now());
        postRepository.save(post);
    }

    @Override
    public void deleteById(long theId) {
        postRepository.deleteById(theId);
    }

//    private User userInfo() {
//        String username = getUserName();
//        User user = userRepository.findByEmail(username);
//        return user;
//    }
//
//    private static String getUserName() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = "";
//        if (principal instanceof UserDetails) {
//            username = ((UserDetails) principal).getUsername();
//        } else {
//            username = principal.toString();
//        }
//        return username;
//    }


    private PostDto mapFromPostToDto(Post post) {
        ModelMapper mapper = new ModelMapper();
        PostDto postDto = mapper.map(post,PostDto.class);
        return postDto;
    }

    private Post mapFromDtoToPost(PostDto postDto) {
        ModelMapper mapper = new ModelMapper();
        Post post = mapper.map(postDto,Post.class);
        return post;
    }
}
