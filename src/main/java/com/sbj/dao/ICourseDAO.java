package com.sbj.dao;

import com.sbj.entity.Course;

import java.util.List;

public interface ICourseDAO {

    List<Course> getAllCourses();
    Course getCourseById(int id);
    void addCourse(Course course);
    boolean exists(int id);
}
