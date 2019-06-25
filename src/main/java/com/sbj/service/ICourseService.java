package com.sbj.service;

import com.sbj.entity.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getAllCourses();
    Course getCourseById(int id);
    boolean addCourse(Course course);
}
