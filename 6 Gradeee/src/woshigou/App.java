package woshigou;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Transcript trans=new Transcript();
		System.out.println("welcome to the transcript app");
		
		while(true){
			
//			String code=sc.next();
			String code=Validator.getString(sc,"Enter course name");
			
			
//			int credit=sc.nextInt();
			int credit=Validator.getInt(sc, "Enter credit hours");
			
			String grade=Validator.getString(sc,"Enter the grade");
//			String grade=sc.next();
//			sc.nextLine();
			
			CourseEnrollment ce=new CourseEnrollment(code,credit,grade);
//			System.out.println(ce);
			trans.addCourse(ce);
			
			System.out.println("add another course?(y/n)");
			String jixu=sc.nextLine();
			if(jixu.equals("n")){
				break;
			}
		}
	    trans.showAllCourse();
	    System.out.println("overall gpa= "+trans.getStringGpa());

	}

}
