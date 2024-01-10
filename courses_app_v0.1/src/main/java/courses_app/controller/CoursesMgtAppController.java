package courses_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import courses_app.model.Course;
import courses_app.model.Student;
import courses_app.service.CourseService;
import courses_app.service.StudentService;

// Do we need to implement the interfaces???
// public class CoursesMgtAppController implements CourseService, StudentRegistrationService{

@Controller
@RequestMapping("/courses")    
public class CoursesMgtAppController{

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;
    

    public CoursesMgtAppController(CourseService theCourseService){
        courseService = theCourseService;
    }

    @RequestMapping("/listCourses")
    public String listCourses(Model theModel){
        List<Course> theCourses = courseService.findAll();
        theModel.addAttribute("courses", theCourses);
        return "courses/listCourses";
    }
    
    @RequestMapping("/showFormForAddCourse")
    public String showFormForAddCourse(Model theModel){
        Course theCourse = new Course();
        theModel.addAttribute("course",theCourse);
        return "courses/courseForm";
    }
    
    
    // Actions for each course
    
    @RequestMapping("/showFormForUpdateCourse")
    public String showFormForUpdateCourse(@RequestParam("courseId") int theId, Model theModel){
        Course theCourse = courseService.findById(theId);
        theModel.addAttribute("course",theCourse);
        return "courses/courseForm";
    }


    @RequestMapping("/listStudents")
    public String listStudents(Model theModel, @RequestParam("courseId") int theId){
        Course theCourse = courseService.findById(theId);
        // tried to directly use the findById(theId) method in the students table
        // that returns the students depending on their id, not the course id they are subscribed to
        List<Student> theStudents = theCourse.getStudents();
        theModel.addAttribute("students",theStudents);
        return "courses/listStudents";
    }

    @RequestMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId") int theId){
        courseService.deleteById(theId);
        return "redirect:/courses/listCourses";
    }
    
    @RequestMapping("/showFormForAddStudent")
    public String showFormForAddStudent(Model theModel){
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "courses/studentForm";
    }

    @RequestMapping("/showFormForUpdateStudent")
    public String showFormForUpdateStudent(@RequestParam("studentId") int theId, Model theModel){
        Student theStudent = studentService.findById(theId);
        theModel.addAttribute("student",theStudent);
        return "courses/studentForm";
    }

    // ERROR here
    // If we redirect to listStudents after the deletion the next error occurs
    // Required request parameter 'courseId' for method parameter type int is not present

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int theId){
        studentService.deleteById(theId);
        return "redirect:/courses/listCourses";
    }

    @RequestMapping("/showStatistics")
    public String showStatistics(@RequestParam("courseId") int theId, Model theModel){
        
        return "courses/statistics";
    }
}