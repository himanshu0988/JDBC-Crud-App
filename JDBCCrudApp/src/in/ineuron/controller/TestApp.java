package in.ineuron.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefectory.StudentServiceFectory;

public class TestApp {

	public static void main(String[] args)throws Exception
	{BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	while (true) {

		System.out.println("1. CREATE");
		System.out.println("2. READ");
		System.out.println("3. UPDATE");
		System.out.println("4. DELETE");
		System.out.println("5. EXIT");
		System.out.print("ENTER UR CHOICE, PRESS[1/2/3/4/5]::  ");
		String option = br.readLine();

		switch (option) {
		case "1":
			insertOperation();
			break;
		case "2":
			searchOperation();
			break;
		case "3":
			updateOperation();
			break;
		case "4":
			deleteOPeration();
			break;
		case "5":
			System.out.println("******* Thanks for using the application *****");
			System.exit(0);
		default:
			System.out.println("Invalid option plz try agin with valid options....");
			break;
		}

	}
}
	
	private static void updateOperation()throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the student id to be updated:: ");
		String sid = br.readLine();
		
		IStudentService studentService=StudentServiceFectory.getStudentService();
		Student std=studentService.searchStudent(Integer.parseInt(sid));
		
		if(std!=null)
		{
			Student newStudent=new Student();
			System.out.println("Student id is :: " + std.getId());
			newStudent.setId(std.getId());
			
			System.out.print("Student oldName is :: " + std.getName() + "  Enter newName :: ");
			String newName = br.readLine();
			if(newName.equals("") || newName == "")
			{
				newStudent.setName(std.getName());
			}else {
				newStudent.setName(newName);
			}
			System.out.print("Student oldAGe is :: " + std.getAge() + "  Enter newAge :: ");
			String newAge = br.readLine();
			if(newName.equals("") || newName == "")
			{
				newStudent.setAge(std.getAge());
			}else {
				newStudent.setAge(Integer.parseInt(newAge));
			}
			System.out.println("new Object data is :: " + newStudent);
			System.out.println();

			String status = studentService.updateStudent(newStudent);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("record updated succesfully");
			} else {
				System.out.println("record updation failed");
			}

		} else {
			System.out.println("Student record not available for the given id  " + sid + " for updation...");
		}

		}
		
	
	private static void insertOperation() {

		IStudentService studentService=StudentServiceFectory.getStudentService();
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the id");
		int id=scan.nextInt();
		System.out.println("enter the name");
		String name=scan.next();
		System.out.println("enter the age");
		int age=scan.nextInt();
		String msg=studentService.addStudent(id,name, age);
		if(msg.equalsIgnoreCase("success"))
		{
			System.out.println("data inserted sucessfully....");
		}else
		{
			System.out.println("data not inserted");
		}
		
	}
	private static void searchOperation()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the id");
		int id=scan.nextInt();
		
		IStudentService studentService=StudentServiceFectory.getStudentService();
	    Student std=studentService.searchStudent(id);
		if(std != null)
		{
			System.out.println("id\tname\tage");
			System.out.println(std.getId()+"\t"+std.getName()+"\t"+std.getAge());
		}
		else if(std == null)
		{
			System.out.println("record not found");
		}
		
	}
	private static void deleteOPeration()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the id");
		int id=scan.nextInt();
		IStudentService studentservice=StudentServiceFectory.getStudentService();
		String msg=studentservice.deleteStudent(id);
		if(msg.equalsIgnoreCase("success"))
		{
			System.out.println("data delete successfully");
		}
		else
		{
			System.out.println("data not avilable");
		}
		
	}
	

}
