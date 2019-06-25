package com.sbj.controller;

import com.sbj.entity.Course;
import com.sbj.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@Path("/api/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @GET
    @Produces("application/json")
    public ResponseEntity<List<Course>> getAllCourses() {
        System.out.println("GET: getAllCourses");
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }

    @GET
    @Path("/levels")
    @Produces("application/json")
    public ResponseEntity<List<Course.Levels>> getDifficultyLevels() {
        return new ResponseEntity<List<Course.Levels>>(Arrays.asList(Course.Levels.values()), HttpStatus.OK);
    }

    @GET
    @Path("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id) {
        System.out.println("GET: getCourseById");
        Course course = courseService.getCourseById(id);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

//    @POST
//    @Path("course")
//    public ResponseEntity<Void> addCourse(@RequestBody Course course, UriComponentsBuilder builder) {
//        boolean flag = courseService.addCourse(course);
//        if (!flag) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        } else {
//            return new ResponseEntity<Void>(HttpStatus.CREATED);
//        }
//    }
}