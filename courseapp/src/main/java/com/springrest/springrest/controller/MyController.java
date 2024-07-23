package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.services.CourseService;

@RestController
@Controller
public class MyController {

	@GetMapping("/home")
	public String home() {
		return "Welcome to course application";
	}
	@Autowired
	 private CourseService serv;
	
	//get the courses using id
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.serv.getCourse();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourses(@PathVariable String courseId){
		
		return this.serv.getCourses(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.serv.addCourse(course);
          }
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.serv.updateCourse(course);
	}
	
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.serv.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	
}