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

import springBoot_CollageProject.Dto.Student;
import springBoot_CollageProject.Service.StudentService;
import springBoot_CollageProject.Util.ResponseStructure;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/insertStudent")
	public ResponseStructure<Student> insert(@RequestBody Student student) {
		return studentService.insert(student);
	}
	
	@GetMapping("/findAllStudent")
	public ResponseStructure<Student> findAll(Student student)
	{
		return studentService.findAll(student);
	}
	
	@GetMapping("/findByIdStudent")
	public ResponseEntity<ResponseStructure<Student>> findById(@RequestParam int studentId)
	{
		return studentService.findById(studentId);
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<ResponseStructure<Student>> update(@RequestParam int studentId,@RequestBody Student student)
	{
		return studentService.update(studentId, student);
	}
	
	@DeleteMapping("/deleteStudent")
	public ResponseEntity<ResponseStructure<Student>> delete(int studentId)
	{
		return studentService.delete(studentId);
	}
}
