package com.springrest.springrest.services;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entity.Course;
@Service
public class coursesserviceimpl implements CourseService {

	List<Course> list;
	@Autowired
   private CourseDao dao;

	public coursesserviceimpl() {
//	  list = new ArrayList<>();	
//	  list.add(new Course(145,"Java Core Course" , "This course contains basic of java"));
//	  list.add(new Course(146,"Java Spring Course" , "This course contains basic of Spring"));
//	  list.add(new Course(154,"Java Rest Course" , "This course contains basic of REST"));
	}




	@Override
	public List<Course> getCourse() {
		
		//return list;
		return dao.findAll();
	}
	public Course getCourses(long courseId) {
//		Course c =null;
//		for(Course course:list) {
//			if(course.getId() == courseId) {
//				c =course;
//				break;
//			}
//		}
//		return c;
		return dao.getOne(courseId);
	}




	@Override
	public Course addCourse(Course course) {
//		 list.add(course);
//		return course;
		dao.save(course);
	    return course;	
	}




	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
//		list.forEach(e->{
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDesc(course.getDesc());
//			}
//		});
//		return course;
		
		dao.save(course);
		return course;
		
	}




	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		// list=this.list.stream().filter(e->e.getId() != parseLong).collect(Collectors.toList());
		Course entity = dao.getOne(parseLong);
		dao.delete(entity);
	}






}
 