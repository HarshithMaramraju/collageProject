package springBoot_CollageProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springBoot_CollageProject.Dto.Collage;
import springBoot_CollageProject.Dto.Course;
import springBoot_CollageProject.Service.CourseService;
import springBoot_CollageProject.Util.ResponseStructure;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@PostMapping("/insertCourse")
	public ResponseStructure<Course> insert(@RequestBody Course course) {
		return courseService.insert(course);
	}
	
	@GetMapping("/findAllCourse")
	public ResponseStructure<Course> findAll(Course course)
	{
		return courseService.findAll(course);
	}
	
	@GetMapping("/findByIdCourse")
	public ResponseEntity<ResponseStructure<Course>> findById(@RequestParam int courseId)
	{
		return courseService.findById(courseId);
	}
	
	@PutMapping("/updateCourse")
	public ResponseEntity<ResponseStructure<Course>> update(@RequestParam int courseId,@RequestBody Course course)
	{
		return courseService.update(courseId, course);
	}
	
	@DeleteMapping("/deleteCourse")
	public ResponseEntity<ResponseStructure<Course>> delete(int courseId)
	{
		return courseService.delete(courseId);
	}
}
