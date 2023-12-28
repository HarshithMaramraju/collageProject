package springBoot_CollageProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springBoot_CollageProject.Dao.CourseDao;
import springBoot_CollageProject.Dto.Course;
import springBoot_CollageProject.ExceptionHandiling.CourseIIdNotFound;
import springBoot_CollageProject.Util.ResponseStructure;

@Service
public class CourseService {

	@Autowired
	CourseDao courseDao;
	
	public ResponseStructure<Course> insert(Course course) {
		 ResponseStructure<Course> responseStructure = new ResponseStructure<>();
		 responseStructure.setMessage("inserted success");
		 responseStructure.setStatus(HttpStatus.CREATED.value());
		 responseStructure.setData(courseDao.insert(course));
		 return responseStructure;
	}
	
	public ResponseStructure<Course> findAll(Course course) {
		ResponseStructure<Course> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("fetched success");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setDatas(courseDao.findAll(course));
		return responseStructure;
	}
	
	public ResponseEntity<ResponseStructure<Course>> findById(int courseId)
	{
		ResponseStructure<Course> responseStructure = new ResponseStructure<>();
		Course course = courseDao.findById(courseId);
		if (course!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("fetch success");
			responseStructure.setData(courseDao.findById(courseId));
			return new ResponseEntity<ResponseStructure<Course>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new CourseIIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Course>> update(int courseId, Course course)
	{
		ResponseStructure<Course> responseStructure = new ResponseStructure<>();
		Course course2 = courseDao.update(courseId, course);
		if (course2!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("update success");
			responseStructure.setData(courseDao.update(courseId, course2));
			return new ResponseEntity<ResponseStructure<Course>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new CourseIIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Course>> delete(int courseId)
	{
		ResponseStructure<Course> responseStructure = new ResponseStructure<>();
		Course course2 = courseDao.delete(courseId);
		if (course2!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted success");
			responseStructure.setData(courseDao.delete(courseId));
			return new ResponseEntity<ResponseStructure<Course>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new CourseIIdNotFound();
		}
	}
}
