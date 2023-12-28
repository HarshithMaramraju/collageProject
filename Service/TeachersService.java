package springBoot_CollageProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springBoot_CollageProject.Dao.TeacherDao;
import springBoot_CollageProject.Dto.Teachers;
import springBoot_CollageProject.ExceptionHandiling.TeacherIdNotFound;
import springBoot_CollageProject.Util.ResponseStructure;

@Service
public class TeachersService {

	@Autowired
	TeacherDao teacherDao;
	
	public ResponseStructure<Teachers>insert(Teachers teachers) {
		ResponseStructure<Teachers> responseStructure = new ResponseStructure<Teachers>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Inserted Successfully");
		responseStructure.setData(teacherDao.insert(teachers));
		return responseStructure;
	}
	
	public ResponseStructure<Teachers> findAll(Teachers teachers) {
		ResponseStructure<Teachers> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Fetched Successfully");
		responseStructure.setDatas(teacherDao.findAll(teachers));
		return responseStructure;
	}
	
	public ResponseEntity<ResponseStructure<Teachers>> findById(int teachersId) {
		ResponseStructure<Teachers> responseStructure = new ResponseStructure<>();
		Teachers teachers = teacherDao.findById(teachersId);
		if (teachers!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Fetched Successfully");
			responseStructure.setData(teacherDao.findById(teachersId));
			return new ResponseEntity<ResponseStructure<Teachers>>(responseStructure,HttpStatus.FOUND);	
		}
		else {
			 throw new  TeacherIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Teachers>> update(int teachersId, Teachers teachers) {
		ResponseStructure<Teachers> responseStructure = new ResponseStructure<>();
		Teachers teachers2 = teacherDao.update(teachersId, teachers);
		if (teachers2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated Successfully");
			responseStructure.setData(teachers2);
			return new ResponseEntity<ResponseStructure<Teachers>>(responseStructure,HttpStatus.OK);	
		}
		else {
			throw new  TeacherIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Teachers>> delete(int teachersId) {
		ResponseStructure<Teachers> responseStructure = new ResponseStructure<>();
		Teachers teachers = teacherDao.delete(teachersId);
		if (teachers!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted Successfully");
			responseStructure.setData(teacherDao.delete(teachersId));
			return new ResponseEntity<ResponseStructure<Teachers>>(responseStructure,HttpStatus.OK);	
		}
		else {
			throw new  TeacherIdNotFound();
		}
	}
	
	
	
}
