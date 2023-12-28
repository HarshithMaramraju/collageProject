package springBoot_CollageProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springBoot_CollageProject.Dao.StudentDao;
import springBoot_CollageProject.Dto.Student;
import springBoot_CollageProject.Dto.Teachers;
import springBoot_CollageProject.ExceptionHandiling.StudentIdNotFount;
import springBoot_CollageProject.ExceptionHandiling.TeacherIdNotFound;
import springBoot_CollageProject.Util.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;
	
	public ResponseStructure<Student> insert(Student student) {
		ResponseStructure<Student> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Inserted Successfully");
		responseStructure.setData(studentDao.insert(student));
		return responseStructure;
	}
	
	public ResponseStructure<Student> findAll(Student student) {
		ResponseStructure<Student> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Fetched Successfully");
		responseStructure.setDatas(studentDao.findAll(student));
		return responseStructure;
	}
	
	public ResponseEntity<ResponseStructure<Student>> findById(int studentId) {
		ResponseStructure<Student> responseStructure = new ResponseStructure<>();
		Student student = studentDao.findById(studentId);
		if (student!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Fetched Successfully");
			responseStructure.setData(studentDao.findById(studentId));
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);	
		}
		else {
			 throw new  StudentIdNotFount();
		}
	}
	
	public ResponseEntity<ResponseStructure<Student>> update(int studentId, Student student) {
		ResponseStructure<Student> responseStructure = new ResponseStructure<>();
		Student student2 = studentDao.update(studentId, student);
		if (student2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated Successfully");
			responseStructure.setData(studentDao.update(studentId, student2));
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);	
		}
		else {
			throw new  StudentIdNotFount();
		}
	}
	
	public ResponseEntity<ResponseStructure<Student>> delete(int studentId) {
		ResponseStructure<Student> responseStructure = new ResponseStructure<>();
		Student student = studentDao.delete(studentId);
		if (student!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted Successfully");
			responseStructure.setData(studentDao.delete(studentId));
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);	
		}
		else {
			throw new  StudentIdNotFount();
		}
	}
}
