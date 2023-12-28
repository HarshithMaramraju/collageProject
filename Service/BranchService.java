package springBoot_CollageProject.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springBoot_CollageProject.Dao.BranchDao;
import springBoot_CollageProject.Dto.Address;
import springBoot_CollageProject.Dto.Branch;
import springBoot_CollageProject.Dto.Course;
import springBoot_CollageProject.Dto.Fees;
import springBoot_CollageProject.Dto.Principal;
import springBoot_CollageProject.Dto.Student;
import springBoot_CollageProject.Dto.Teachers;
import springBoot_CollageProject.ExceptionHandiling.BranchIdNotFound;
import springBoot_CollageProject.Util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;
	
	public ResponseStructure<Branch> insert(Branch branch)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully inserted");
		responseStructure.setData(branchDao.insert(branch));
		return responseStructure;
	}
	
	public ResponseStructure<Branch> findAll(Branch branch)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully fetched");
		responseStructure.setDatas(branchDao.findAll(branch));
		return responseStructure;
	}
	
	public ResponseEntity<ResponseStructure<Branch>> findById(int branchId) 
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.findById(branchId);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("fethed success");
			responseStructure.setData(branchDao.findById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);			
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> update(int branchId, Branch branch) 
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch2 = branchDao.update(branchId, branch);
		if (branch2!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated successfully");
			responseStructure.setData(branchDao.findById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);			
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> delete(int branchId) 
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.delete(branchId);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted successfully");
			responseStructure.setData(branchDao.delete(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);			
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingCollage(int branchId, int addressId)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.addExistingAddressToExistingCollage(branchId, addressId);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(branchDao.addExistingAddressToExistingCollage(branchId, addressId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(int branchId, Address address)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.findById(branchId);
		if (branch!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfylly");
			responseStructure.setData(branchDao.addNewAddressToExistingBranch(branchId, address));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingPrincipalToExistingBranch(int branchId, int principalId)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.addExistingPrincipalToExistingBranch(branchId, principalId);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(branchDao.addExistingPrincipalToExistingBranch(branchId, principalId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewPrincipalToExistingBranch(int branchId, Principal principal)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.findById(branchId);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(branchDao.addNewPrincipalToExistingBranch(branchId, principal));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingTeacherToExistingBranch(int branchId, int teacherId)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.addExistingTeacherToExistingBranch(teacherId, teacherId);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(branchDao.addExistingTeacherToExistingBranch(teacherId, teacherId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewTeacherToExistingBranch(int branchId, List<Teachers> teachers) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.addNewTeacherToExistingBranch(branchId, teachers);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(branchDao.addNewTeacherToExistingBranch(branchId, teachers));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingStudentToExistingBranch(int branchId, int studentId)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.findById(branchId);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(branchDao.addExistingStudentToExistingBranch(branchId, studentId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewStudentToEistingBranch(int branchId, List<Student> students)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.addNewStudentToEistingBranch(branchId, students);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(branchDao.addNewStudentToEistingBranch(branchId, students));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingFeeToExistingBranch(int branchId, int feeId)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.findById(branchId);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(branchDao.addExistingFeeToExistingBranch(branchId, feeId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewFeeToExistingBranch(int branchId, List<Fees> fees)
	{
		ResponseStructure<Fees> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.addNewFeeToExistingBranch(branchId, fees);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setDatas(fees);
			return new ResponseEntity<ResponseStructure<Branch>>(HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingCourseToExistingBranch(int branchId, int courseId)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch  branch = branchDao.findById(branchId);
		if (branch!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(branchDao.addExistingCourseToExistingBranch(branchId, courseId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);	
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewCourseToExsitingBranch(int branchId, List<Course> courses)
	{
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Branch branch = branchDao.addNewCourseToExistingbranch(branchId, courses);
		if (branch!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("added successfully");
			responseStructure.setData(branchDao.addNewCourseToExistingbranch(branchId, courses));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else
		{
			throw new BranchIdNotFound();
		}
	}
}

