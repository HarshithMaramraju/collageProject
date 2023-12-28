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

import springBoot_CollageProject.Dto.Teachers;
import springBoot_CollageProject.Service.TeachersService;
import springBoot_CollageProject.Util.ResponseStructure;

@RestController
public class TeacherController {

	@Autowired
	TeachersService teachersService;
	
	@PostMapping("/insertTeacher")
	public ResponseStructure<Teachers> insert(@RequestBody Teachers teachers)
	{
		return teachersService.insert(teachers);
	}
	
	@GetMapping("/FetchAllTeachers")
	public ResponseStructure<Teachers> findAll(Teachers teachers)
	{
		return teachersService.findAll(teachers);
	}
	
	@GetMapping("/fetchByIdteachers")
	public ResponseEntity<ResponseStructure<Teachers>> findById(@RequestParam int teacherId)
	{
		return teachersService.findById(teacherId);
	}
	
	@PutMapping("/updateTeachers")
	public ResponseEntity<ResponseStructure<Teachers>> update(@RequestParam int teacherId, @RequestBody Teachers teachers)
	{
		return teachersService.update(teacherId, teachers);
	}
	
	@DeleteMapping("/deleteTeachers")
	public ResponseEntity<ResponseStructure<Teachers>> delete(@RequestParam int teacherId)
	{
		return teachersService.delete(teacherId);
	}
}
