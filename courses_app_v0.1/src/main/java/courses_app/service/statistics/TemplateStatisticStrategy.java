package courses_app.service.statistics;

import courses_app.model.Course;

public abstract class TemplateStatisticStrategy implements StatisticStrategy {

    
    public TemplateStatisticStrategy() {
    }

    @Override
    public double calculateStatistic(Course theCourse) {
        // TODO Auto-generated method stub
        return 0;
    }

    abstract public void doActualCalculation();
    
}
