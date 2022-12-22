package com.example.exe1.repository;

import com.example.exe1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findByTitleContaining(String title, Pageable pageable);
}
