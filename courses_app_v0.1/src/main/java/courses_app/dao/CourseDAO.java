package courses_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import courses_app.model.Course;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer>{
    
    public Course findById(int theId);
}
