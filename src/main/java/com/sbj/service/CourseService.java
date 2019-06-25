package com.sbj.service;

import com.sbj.dao.ICourseDAO;
import com.sbj.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseDAO courseDAO;

    @Override
    @Transactional
    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    @Override
    @Transactional
    public Course getCourseById(int id) {
        return courseDAO.getCourseById(id);
    }

    @Override
    @Transactional
    public synchronized boolean addCourse(Course course) {
        if(courseDAO.exists(course.getCourseId())){
            return false;
        }else{
            courseDAO.addCourse(course);
            return true;
        }
    }
}
