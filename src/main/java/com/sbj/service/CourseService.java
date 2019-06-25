package com.sbj.service;

import com.sbj.dao.ICourseDAO;
import com.sbj.entity.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Resource
    private ICourseDAO courseDAO;

    @Override
    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    @Override
    public Course getCourseById(int id) {
        return courseDAO.getCourseById(id);
    }

    @Override
    public synchronized boolean addCourse(Course course) {
        if(courseDAO.exists(course.getCourseId())){
            return false;
        }else{
            courseDAO.addCourse(course);
            return true;
        }
    }
}
