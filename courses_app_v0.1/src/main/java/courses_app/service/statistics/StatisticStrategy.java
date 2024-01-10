package courses_app.service.statistics;

import courses_app.model.Course;

// an interface that can have different implementations one for each statistic (e.g. mean, max,min, skewness, etc.) 
public interface StatisticStrategy {
    
    public double calculateStatistic(Course theCourse);
}
