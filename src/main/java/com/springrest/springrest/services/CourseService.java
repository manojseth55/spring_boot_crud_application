package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.model.Courses;

public interface CourseService {

	public List<Courses> getCourses();

	public Courses getCourseById(long id);

	public Courses save(Courses course);

	public void deleteById(long id);

}