package springBoot_CollageProject.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBoot_CollageProject.Dto.Teachers;
import springBoot_CollageProject.Repo.TeachersRepo;

@Repository
public class TeacherDao {

	@Autowired
	TeachersRepo teachersRepo;
	
	public Teachers	insert(Teachers teachers)
	{
		return teachersRepo.save(teachers);
	}
	
	public List<Teachers> findAll(Teachers teachers)
	{
		return teachersRepo.findAll();
	}
	
	public Teachers findById(int teachersId) {
		Optional<Teachers> teachers = teachersRepo.findById(teachersId);
		if (teachers.isPresent())
		{
			return teachers.get();
		}
		else
		{
			return null;
		}
	}
	
	public Teachers update(int teacherId, Teachers teachers)
	{
		Optional<Teachers> teachers2 = teachersRepo.findById(teacherId);
		if (teachers2.isPresent())
		{
			teachers.setTeacheerId(teacherId);
			return this.insert(teachers);
		}
		else
		{
			return null;
		}
	}
	
	public Teachers delete(int teachersId)
	{
		Optional<Teachers> teachers = teachersRepo.findById(teachersId);
		if (teachers.isPresent())
		{
			teachersRepo.deleteById(teachersId);
			return teachers.get();
		}
		else
		{
			return null;
		}
	}
	
	
}



