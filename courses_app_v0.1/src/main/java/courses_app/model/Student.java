package courses_app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "course_id")
	private String course_id;

	@Column(name = "final_exam")
	private int final_exam;
	
	@Column(name = "project")
	private int project;

	@Column(name = "year")
	private int year;


	public Student(int id, String first_name, String last_name, String course_id, int final_exam, int project, int year) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.course_id = course_id;
		this.final_exam = final_exam;
		this.project = project;
		this.year = year;
	}

	public Student() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public int getFinal_exam() {
		return final_exam;
	}

	public void setFinal_exam(int final_exam) {
		this.final_exam = final_exam;
	}

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [course_id=" + course_id + ", final_exam=" + final_exam + ", first_name=" + first_name + ", id="
				+ id + ", last_name=" + last_name + ", project=" + project + ", year=" + year + "]";
	}

	
}
