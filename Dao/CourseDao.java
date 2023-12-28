package springBoot_CollageProject.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBoot_CollageProject.Dto.Course;
import springBoot_CollageProject.Repo.CourseRepo;

@Repository
public class CourseDao {

	@Autowired
	CourseRepo courseRepo;
	
	public Course insert(Course course)
	{
		return courseRepo.save(course);
	}
	
	public List<Course> findAll(Course course)
	{
		return courseRepo.findAll();
	}
	
	public Course findById(int courseId)
	{
		Optional<Course> course = courseRepo.findById(courseId);
		if (course.isPresent())
		{
			return course.get();
		}
		else
		{
			return null;
		}
	}
	
	public Course update(int courseId, Course course)
	{
		Optional<Course> course2 = courseRepo.findById(courseId);
		if (course2.isPresent())
		{
			course.setCourseId(courseId);
			return this.insert(course);
		}
		else
		{
			return null;
		}
	}
	
	public Course delete(int courseId)
	{
		Optional<Course> course = courseRepo.findById(courseId);
		if (course.isPresent())
		{
			courseRepo.deleteById(courseId);
			return course.get();
		}
		else
		{
			return null;
		}
	}
}
