package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.model.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public String home() {
		return "This is the home page for courses api";
	}

	@GetMapping("/courses")
	public ResponseEntity<List<Courses>> getCourse() {
		try {
			return new ResponseEntity<>(this.courseService.getCourses(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/courses/{id}")
	public ResponseEntity<Courses> getCourseById(@PathVariable("id") long id) {
		try {
			Courses course = this.courseService.getCourseById(id);
			if (course != null) {
				return new ResponseEntity<>(course, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("add")
	public ResponseEntity<Courses> addCourse(@RequestBody Courses course) {

		try {
			return new ResponseEntity<>(this.courseService.save(course), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("add")
	public ResponseEntity<Courses> updateCourse(@RequestBody Courses course) {

		try {
			return new ResponseEntity<>(this.courseService.save(course), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/courses/{id}")
	  public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {
	    try {
	    	this.courseService.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }	
}
