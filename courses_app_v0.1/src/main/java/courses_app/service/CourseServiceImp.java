package courses_app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import courses_app.dao.CourseDAO;
import courses_app.model.Course;
import courses_app.service.statistics.StatisticStrategy;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseDAO courseRepository;

    public CourseServiceImp(){
        super();
    }

    @Autowired
    public CourseServiceImp(CourseDAO theCourseRepository){
        courseRepository = theCourseRepository;
    }

    @Override
    @Transactional
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int theId) {
		Course result = courseRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the course
			throw new RuntimeException("Did not find course id - " + theId);
		}
    }

    @Override
    public void deleteById(int theId) {
        courseRepository.deleteById(theId);
    }

    public List<StatisticStrategy> getStatCalculationStrategies(){
        
        return null;
    }
    
}
