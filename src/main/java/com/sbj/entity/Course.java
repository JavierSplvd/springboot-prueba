package com.sbj.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "courses")
public class Course implements Serializable {

    public enum Levels {
        BEGINNER, INTERMEDIATE, ADVANCED
    }

    public Course() {
    }

    public Course(int courseId, String title, String teacher, Levels level, int hours) {
        this.courseId = courseId;
        this.title = title;
        this.teacher = teacher;
        this.level = level;
        this.hours = hours;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_title")
    private String title;
    @Column(name = "course_teacher")
    private String teacher;
    @Column(name = "course_level")
    private Levels level;
    @Column(name = "course_hours")
    private int hours;
    @Column
    private boolean active;

    private Levels parseLevel(String level) {
        Levels newLevel = Levels.valueOf(level.toUpperCase());
        return newLevel;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getTeacher() {
        return teacher;
    }

public Levels getLevel() {
        return level;
        }

public int getHours() {
        return hours;
        }
        }