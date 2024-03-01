package com.zikri.twitter.service;

import com.zikri.twitter.dto.PostRequest;
import com.zikri.twitter.dto.PostResponse;
import com.zikri.twitter.dto.UserResponse;
import com.zikri.twitter.entity.Post;
import com.zikri.twitter.entity.User;
import com.zikri.twitter.repository.PostRepository;
import com.zikri.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public PostResponse createPost(PostRequest postRequest, UserResponse userResponse) {
        User user = userRepository.findById(userResponse.getId());

        Post post = new Post();
        post.setUser(user);
        post.setPost(postRequest.getPost());
        Post postResult = postRepository.save(post);

        return convertToPostResponse(postResult);
    }

    public List<PostResponse> getAllPost() {
        List<Post> allUserPost = postRepository.findAllByOrderByIdDesc();

        return allUserPost.stream()
                .map(this::convertToPostResponse)
                .collect(Collectors.toList());
    }

    public List<PostResponse> getMyPosts(UserResponse userResponse) {
        List<Post> allUserPost = postRepository.findAllByUserId(userResponse.getId());
        return allUserPost.stream()
                .map(this::convertToPostResponse)
                .collect(Collectors.toList());
    }

    private PostResponse convertToPostResponse(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .post(post.getPost())
                .user( UserResponse.builder()
                                .id(post.getUser().getId())
                                .name(post.getUser().getName())
                                .username(post.getUser().getUsername())
                                .build())
                .build();
    }
}
