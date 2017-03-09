package woshigou;

public class CourseEnrollment {

	private String code;
	private int credits;
	private String grade;
	
	public CourseEnrollment(String code, int credits, String grade){
		this.code=code;
		this.credits=credits;
		this.grade=grade;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public double gradeToGpa(){
		if(grade.equals("a")){
			return 4.0;
		}else if(grade.equals("b")){
			return 3.0;
		}else if(grade.equals("c")){
			return 2.0;
		}else if(grade.equals("d")){
			return 1.0;
		}
		return 0.0;
	}
	
//	public String toString(){
//		return String.format("%-15s%-12s%-10s%s", 
//				code, credits, grade, gradeToGpa());
//	}
	
	public String toString(){
		return String.format("%-15s%-12s%-10s%s\n", 
				code, credits, grade, gradeToGpa());
	}
	
}













