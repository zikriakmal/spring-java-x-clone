package com.zikri.twitter.repository;

import com.zikri.twitter.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByOrderByIdDesc();
    List<Post> findAllByUserId(Integer userId);

}
