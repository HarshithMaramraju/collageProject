package springBoot_CollageProject.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBoot_CollageProject.Dto.Student;
import springBoot_CollageProject.Repo.StudentRepo;

@Repository
public class StudentDao {

	@Autowired
	StudentRepo studentRepo;
	
	public Student insert(Student student)
	{
		return studentRepo.save(student);
	}
	
	public List<Student> findAll(Student student)
	{
		return studentRepo.findAll();
	}
	
	public Student findById(int studentId) {
		Optional<Student> student = studentRepo.findById(studentId);
		if (student.isPresent())
		{
			return student.get();
		}
		else
		{
			return null;
		}
	}
	
	public Student update(int studentId, Student student)
	{
		Optional<Student> student2 = studentRepo.findById(studentId);
		if (student2.isPresent())
		{
			student.setStudentId(studentId);
			return this.insert(student);
		}
		else
		{
			return null;
		}
	}
	
	public Student delete(int studentId)
	{
		Optional<Student> student = studentRepo.findById(studentId);
		if (student.isPresent())
		{
			studentRepo.deleteById(studentId);
			return student.get();
		}
		else
		{
			return null;
		}
	}
}
