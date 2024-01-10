package courses_app.service;

import java.util.List;

import courses_app.model.Course;

public interface CourseService {
    
    public List<Course> findAll();
    public Course findById(int theId);
    public void deleteById(int theId);
}
