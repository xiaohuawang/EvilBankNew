package woshigou;

import java.util.ArrayList;

public class Transcript {
	
	private ArrayList<CourseEnrollment> courses=new ArrayList<CourseEnrollment>();

	public Transcript(){
	
	}
	
	public ArrayList<CourseEnrollment> getCourses() {
		return courses;
	}
	
	public void addCourse(CourseEnrollment courseEnrollment){
		courses.add(courseEnrollment);
	}
	
	public double getOverallGpa(){
        double gpa=0.0;
//        for(int i=0;i<courses.size();i++){
//        	gpa=gpa+courses.get(i).gradeToGpa();
//        }
        for(CourseEnrollment course: courses){
        	gpa=gpa+course.gradeToGpa();
        }
        gpa=gpa/courses.size();
        return gpa;
	}
	
	public void showAllCourse(){
		for(int i=0;i<courses.size();i++){
			System.out.println(String.format("%-15s%-12d%-10s%s\n", 
					courses.get(i).getCode(), courses.get(i).getCredits(),courses.get(i).getGrade(),courses.get(i).gradeToGpa()));
//			System.out.print("code= "+courses.get(i).getCode()+" ");
//			System.out.print("code= "+courses.get(i).getCredits()+" ");
//			System.out.print("code= "+courses.get(i).getCredits()+" ");
//			System.out.println();
		}
	}
	
	public String getStringGpa(){
		return Double.toString(getOverallGpa());
	}

//	public void setCourses(ArrayList<CourseEnrollment> courses) {
//		this.courses = courses;
//	}
	
	
} 
