package com.springrest.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.model.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long>{

}
