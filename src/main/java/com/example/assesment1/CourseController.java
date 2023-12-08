package com.example.assesment1;
import com.example.assesment1.Entity.Courses;
import com.example.assesment1.CourseService;
import com.example.assesment1.Entity.Learners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController     //t is typically used to build RESTful web services by combining the @Controller and @ResponseBody annotations.
@RequestMapping("/courses")
public class CourseController {
    @Autowired
  CourseService courseService;
    @GetMapping("/getAll") //for get request
    public List<Courses> getAllCourses(){
        return courseService.getAllCourses();
    }
   @GetMapping("/Courses/{id}")
    public Courses getById(@PathVariable int id){
        return courseService.getCoursesById(id);
    }

    @PostMapping("add")
    public Courses insertCourse(@RequestBody Courses course)
    {
        return courseService.insertCourse(course);
    }


    @PostMapping("update")
    public Courses updateCourse(@RequestBody Courses course)
    {
        return courseService.updateCourse(course);
    }

    //----------------------------------------------------------
    @GetMapping("/{id}")
    public Courses getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/del/{id}")
    public void removeCoursesById(@PathVariable int id){
        courseService.removeCoursesById(id);
    }
    @GetMapping("/delAll")
    public  void removeAll(){
        courseService.removeAllCourses();
    }
    @GetMapping("/findcount")
    public long findCount(){
        return courseService.findCountCourses();
    }

    @GetMapping("/indicateID/{id}")
    public String indicateID(@PathVariable int id){
        return courseService.indicateCoursesById(id);
    }


}
