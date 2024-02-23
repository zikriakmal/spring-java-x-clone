package com.zikri.twitter.repository;

import com.zikri.twitter.entity.Post;
import com.zikri.twitter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, String> {

    List<Post> findAllByUserId(Integer userId);
}
