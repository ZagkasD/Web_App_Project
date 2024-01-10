package courses_app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
     private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "instructor")
    private String instructor;
    
    @Column(name = "year")
    private int year;

    @Column(name = "semester")
    private String semester;
    
    // One course can be followed by many students
    // One to many relation
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Student> students;

    public Course(){

    }

    public Course(int id, String name, String description, String instructor, int year, String semester) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.year = year;
        this.semester = semester;
        this.students = new ArrayList<Student>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
        
    @Override
    public String toString() {
        return "Course [description=" + description + ", id=" + id + ", instructor=" + instructor + ", name=" + name
                + ", semester=" + semester + ", year=" + year + "]";
    }

    
    
}
