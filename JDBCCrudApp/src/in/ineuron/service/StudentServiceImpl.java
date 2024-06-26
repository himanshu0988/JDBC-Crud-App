package in.ineuron.service;

import in.ineuron.daofectory.StudentDaofectory;
import in.ineuron.dto.Student;
import in.ineuron.presistence.IStudentDao;
import in.ineuron.servicefectory.StudentServiceFectory;

public class StudentServiceImpl implements IStudentService
{

	IStudentDao studentdao=null;
	@Override
	public String addStudent(Integer id, String name, Integer age) {
		if(studentdao==null)
		{
			studentdao=StudentDaofectory.getStudentDao();
		}
	return studentdao.addStudent(id, name, age);
		
	}

	@Override
	public Student searchStudent(Integer id) 
	{
		studentdao=StudentDaofectory.getStudentDao();
		return studentdao.searchStudent(id);
	}

	@Override
	public String updateStudent(Student student) {
		studentdao=StudentDaofectory.getStudentDao();
		return studentdao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer id) {
	if(studentdao==null)
	{
		studentdao=StudentDaofectory.getStudentDao();
	}
	return studentdao.deleteStudent(id);
	}

}
