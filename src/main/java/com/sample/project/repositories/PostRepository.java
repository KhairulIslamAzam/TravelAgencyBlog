package com.sample.project.repositories;

import com.sample.project.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "select * from post as p where p.user_id = ?1",nativeQuery = true)
    List<Post> findPosts(long id);
}
