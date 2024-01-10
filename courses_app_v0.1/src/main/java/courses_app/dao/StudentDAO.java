package courses_app.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import courses_app.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{

    public Student findById(int theId);
    
}
