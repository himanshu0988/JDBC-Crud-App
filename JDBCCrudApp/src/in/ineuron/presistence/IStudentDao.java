package in.ineuron.dao;

public interface IStudentDao 
{
	public String addStudent(Integer id,String name,Integer age);
	public Student searchStudent(Integer id);
	public String updateStudent(Integer id,String name,Integer age);
	public String deleteStudent(Integer id);

}
