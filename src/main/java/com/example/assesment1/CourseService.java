package com.example.assesment1;
import com.example.assesment1.Entity.Learners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.assesment1.Entity.Courses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    public Courses getCoursesById(int id) {
        return courseRepository.findById(id).get();
    }

    /*public void updateCourseById(int id, Courses coursedetails) {
        Optional<Courses> tempCoursesId = courseRepository.findById(id);
        if (tempCoursesId.isEmpty()) {
            throw new RuntimeException("Courses id" + id + "doesn't exist");
        } else if (coursedetails.getCourse_name().isEmpty()) {
            throw new RuntimeException("Course name for id " + id + "doesn't exist");
        } else if (coursedetails.getCourse_description().isEmpty()) {
            throw new RuntimeException("Course description for id " + id + "doesn't exist");
        }
        coursedetails.setCourse_name(coursedetails.getCourse_name());
        coursedetails.setCourse_description(coursedetails.getCourse_description());
    }*/

    //Insert Course
    public Courses insertCourse(Courses course) {
        return courseRepository.save(course);
    }


    public Courses updateCourse(Courses course) {
        var temp = courseRepository.findById(course.getCourse_Id());
        if (temp.isEmpty()) {

            throw new RuntimeException("Courses id doesn't exist");

        }
        var upCourse = temp.get();
        if (course.getCourse_name() != null) {
            upCourse.setCourse_name(course.getCourse_name());
        }
        if (course.getCourse_description() != null) {
            upCourse.setCourse_description(course.getCourse_description());
        }
        return courseRepository.save(upCourse);
    }

    //--------------------------------------------------------------------------
    public Courses getCourseById(int id) {
        return courseRepository.findById(id).get();
    }

    //create Learners
    public Courses createCourses(Courses courses) {
        return courseRepository.save(courses);
    }

    //remove Learners
    public void removeCoursesById(int id) {
        Optional<Courses> tempLearners = courseRepository.findById(id);
        if (tempLearners.isEmpty()) {
            throw new RuntimeException("Course id" + id + "doesn't exist");
        }
        courseRepository.deleteById(id);
    }

    //remove all Learnerss
    public void removeAllCourses() {
        courseRepository.deleteAll();
    }

    public long findCountCourses() {
        return courseRepository.findAll().size();
    }

    public String indicateCoursesById(int id) {
        Optional<Courses> tempLearners = courseRepository.findById(id);
        if (tempLearners.isEmpty()) {

                return "ID does not exist";
            }
            return "ID is PRESENT";
    }


}
