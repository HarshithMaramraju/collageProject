package springBoot_CollageProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.models.Response;
import springBoot_CollageProject.Dao.CollageDao;
import springBoot_CollageProject.Dto.Branch;
import springBoot_CollageProject.Dto.Collage;
import springBoot_CollageProject.ExceptionHandiling.CollageIdNotFound;
import springBoot_CollageProject.ExceptionHandiling.TeacherIdNotFound;
import springBoot_CollageProject.Util.ResponseStructure;

@Service
public class CollageService {

	@Autowired
	CollageDao collageDao;
	
	public ResponseStructure<Collage> insertCollage(Collage collage)
	{
		ResponseStructure<Collage> responseStructure = new ResponseStructure<Collage>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted");
		responseStructure.setData(collageDao.insertCollage(collage));
		return responseStructure;
	}
	
	public ResponseStructure<Collage> fetchAll(Collage collage)
	{
		ResponseStructure<Collage> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Fetched");
		responseStructure.setDatas(collageDao.fetchAllCollage(collage));
		return responseStructure;
	}
	
	public ResponseEntity<ResponseStructure<Collage>> findById(int collageId)
	{
		ResponseStructure<Collage> responseStructure = new ResponseStructure<>();
		Collage collage = collageDao.fetchByIdCollage(collageId);
		if (collage!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfullly fetched by id");
			responseStructure.setData(collageDao.fetchByIdCollage(collageId));
			return new ResponseEntity<ResponseStructure<Collage>>(responseStructure,HttpStatus.FOUND);
		}
		else
		{
			throw new CollageIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Collage>> update(int collageId, Collage collage) {
	
		ResponseStructure<Collage> responseStructure = new ResponseStructure<>();
		Collage collage2 = collageDao.updateCollage(collageId, collage);
		if (collage2!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated successfully");
			responseStructure.setData(collage2);
			return new ResponseEntity<ResponseStructure<Collage>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			 throw new TeacherIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Collage>> delete(int collageId) {
		ResponseStructure<Collage> responseStructure = new ResponseStructure<>();
		Collage collage = collageDao.delete(collageId);
		if (collage!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setData(collageDao.delete(collageId));
			return new ResponseEntity<ResponseStructure<Collage>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new CollageIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Collage>> addExistingBranchToExistingCollage(int collageId, int branchId) {
		ResponseStructure<Collage> responseStructure = new ResponseStructure<>();
		Collage collage = collageDao.fetchByIdCollage(collageId);
		if (collage!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(collageDao.addExistingBranchToExistingCollage(collageId, branchId));
			return new ResponseEntity<ResponseStructure<Collage>>(responseStructure, HttpStatus.OK);
		}
		else
		{
			throw new CollageIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Collage>> addNewBranchToExistingCollage(int collageId, List<Branch> branchs) {
		ResponseStructure<Collage> responseStructure = new ResponseStructure<>();
		Collage collage = collageDao.addNewBranchToExistingCollage(collageId, branchs);
		if (collage!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(collageDao.addNewBranchToExistingCollage(collageId, branchs));
			return new ResponseEntity<ResponseStructure<Collage>>(responseStructure, HttpStatus.OK);
		}
		else
		{
			throw new CollageIdNotFound();
		}
	}
}
