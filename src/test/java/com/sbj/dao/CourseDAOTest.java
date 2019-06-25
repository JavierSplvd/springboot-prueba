package com.sbj.dao;

import com.sbj.app.Application;
import com.sbj.entity.Course;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CourseDAOTest {

    @Resource
    private CourseDAO courseDAO;

    private Course course;
    private List<Course> courses;

    private static final int NUMBER_COURSES = 3;

    @Before
    public void setUp(){
        course = new Course(1, "My Course", "Javier", Course.Levels.INTERMEDIATE, 50);
    }

    @Test
    public void testDataBase(){
        courses = courseDAO.getAllCourses();
        Assert.assertEquals(courses.size(), NUMBER_COURSES);
    }
}