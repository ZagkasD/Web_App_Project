package courses_app.service;

import courses_app.model.Student;

public interface StudentService {

    public Student findById(int theId);

    public void deleteById(int theId);

}
