package com.example.exe1.repository;

import com.example.exe1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContaining(String title, Pageable pageable);

    @Query(value = "select * from blog where category_id = :id", nativeQuery = true)
    List<Blog> findBlogByCategory(@Param("id") int id);

}
