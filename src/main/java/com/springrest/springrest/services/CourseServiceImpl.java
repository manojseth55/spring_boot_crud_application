package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.model.Courses;
import com.springrest.springrest.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseDao;

	// List<Courses> list;

	public CourseServiceImpl() {
	}

	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public Courses getCourseById(long id) {
		Optional<Courses> course = courseDao.findById(id);
		Courses object = null;
		if (course.isPresent()) {
			object = course.get();
		}
		return object;
	}

	@Override
	public Courses save(Courses course) {
		return courseDao.save(course);
	}

	@Override
	public void deleteById(long id) {
		courseDao.deleteById(id);
	}

}
