package courses_app.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import courses_app.dao.StudentDAO;
import courses_app.model.Student;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDAO studentRepository;

    public StudentServiceImp(){
        super();
    }

    @Autowired
    public StudentServiceImp(StudentDAO theStudentRepository){
        studentRepository = theStudentRepository;
    }

    @Override
    @Transactional
    public Student findById(int theId) {
        Student result = studentRepository.findById(theId);
        if (result != null ) {
            return result;
        }
        else {
            // we didn't find the course
            throw new RuntimeException("Did not find student id - " + theId);
        }
    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);        
    }

    
    public Map<String,Double> getCourseStatistics(){
        return null;
    }


}
