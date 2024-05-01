package in.ineuron.presistence;

import in.ineuron.dto.Student;

public interface IStudentDao 
{
	public String addStudent(Integer id,String name,Integer age);
	public Student searchStudent(Integer id);
	public String deleteStudent(Integer id);
	public String updateStudent(Student student);

}
