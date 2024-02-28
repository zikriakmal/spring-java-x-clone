package com.zikri.twitter.repository;

import com.zikri.twitter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    User findById(Integer id);
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

}
