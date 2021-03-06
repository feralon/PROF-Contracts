package es.upm.grise.profundizacion.contratos.courses;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import es.upm.grise.profundizacion.contratos.values.CourseData;

public abstract class Course implements Comparable<Course> {

	protected int numRegistrations;
	protected CourseData courseData;

	@Requires("course.getCredits() >= 1 && course.getCredits() <= 6 && "
			+ "numRegistrations >= 1 && numRegistrations <= 6")
	@Ensures("getFee() >= 0.0")
	public Course(int numRegistrations, CourseData course) {
		this.numRegistrations = numRegistrations;
		this.courseData = course;
	}

	public String getLevel() {
		return courseData.getLevel();
	}

	public abstract double getFee();

	public String getName() {
		return courseData.getName();
	}

	public int getCredits() {
		return courseData.getCredits();
	}

	@Override
	public int compareTo(Course course) {
		return courseData.getName().compareTo(course.getName());
	}

}
