package com.sbj.dao;

import com.sbj.entity.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseDAO implements ICourseDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Course> getAllCourses() {
//        String query = "FROM com.sbj.entity.Course";
//        return (List<Course>) entityManager.createQuery(query).getResultList();
        List<Course> l = new ArrayList<Course>(2);
        l.add(new Course(1, "Hibernate and JPA with Sprinng Boot", "Ranga Karam", Course.Levels.INTERMEDIATE, 25));
        l.add(new Course(2, "Spring", "Ahmad Seddighi", Course.Levels.INTERMEDIATE, 18));
        l.add(new Course(3, "Machine Learning with R", "Brett Lantz", Course.Levels.INTERMEDIATE, 18));
        l.add(new Course(4, "Windows Server 2019", "James Edison", Course.Levels.ADVANCED, 18));
        l.add(new Course(5, "AWS Penetration Testing with kali Linux", "Benjamin Caudill", Course.Levels.ADVANCED, 15));
        l.add(new Course(6, "Full Stack Development with Go", "Mina Andrawos", Course.Levels.INTERMEDIATE, 10));
        l.add(new Course(7, "C Programming", "B.M. Harwani", Course.Levels.BEGINNER, 15));
        l.add(new Course(8, "Natural Language Processing with Java", "Richard M. Reese", Course.Levels.INTERMEDIATE, 10));
        l.add(new Course(9, "Deep Learning for Computer Vision", "Klevis Ramo", Course.Levels.ADVANCED, 24));
        l.add(new Course(10, "Kotlin for Enterprise Applications using Java EE", "Raghavendra Rao K", Course.Levels.ADVANCED, 17));
        return l;
    }

    @Override
    @Transactional
    public Course getCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void addCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public boolean exists(int id) {
        String query = "";
        int count = entityManager.createQuery(query).setParameter(1, id).getResultList().size();
        return count > 0;
    }
}