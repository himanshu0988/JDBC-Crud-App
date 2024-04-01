package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService
{ 

	public String addStudent(Integer id,String name,Integer age);
	public Student searchStudent(Integer id);
	public String updateStudent(Integer id,String name,Integer age);
	public String deleteStudent(Integer id);


}
