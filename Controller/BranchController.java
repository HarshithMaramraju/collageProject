package springBoot_CollageProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springBoot_CollageProject.Dto.Address;
import springBoot_CollageProject.Dto.Branch;
import springBoot_CollageProject.Dto.Course;
import springBoot_CollageProject.Dto.Fees;
import springBoot_CollageProject.Dto.Principal;
import springBoot_CollageProject.Dto.Student;
import springBoot_CollageProject.Dto.Teachers;
import springBoot_CollageProject.Service.BranchService;
import springBoot_CollageProject.Util.ResponseStructure;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@PostMapping("/insertBranch")
	public ResponseStructure<Branch> insert(@RequestBody Branch branch)
	{
		return branchService.insert(branch);
	}
	
	@GetMapping("/findAllBranch")
	public ResponseStructure<Branch> findAll(Branch branch)
	{
		return branchService.findAll(branch);
	}
	
	@GetMapping("/findById")
	public ResponseEntity<ResponseStructure<Branch>> findById(@RequestParam int branchId)
	{
		return branchService.findById(branchId);
	}
	
	@PutMapping("/updateBranch")
	public ResponseEntity<ResponseStructure<Branch>> update(@RequestParam int branchId, @RequestBody Branch branch)
	{
		return branchService.update(branchId, branch);
	}
	
	@DeleteMapping("/deleteBranch")
	public ResponseEntity<ResponseStructure<Branch>> delete(@RequestParam int branchId)
	{
		return branchService.delete(branchId);
	}
	
	@PutMapping("/addExistingAddressToExistingCollage")
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingCollage(@RequestParam int branchId, @RequestParam int addressId)
	{
		return branchService.addExistingAddressToExistingCollage(branchId, addressId);
	}
	
	@PutMapping("/addNewAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(@RequestParam int branchId, @RequestBody Address address)
	{
		return branchService.addNewAddressToExistingBranch(branchId, address);
	}
	
	@PutMapping("/addExistingPrincipalToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingPrincipalToExistingBranch(@RequestParam int branchId, @RequestParam int pricipalId)
	{
		return branchService.addExistingPrincipalToExistingBranch(branchId, pricipalId);
	}
	
	@PutMapping("/addNewPrincipalToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewPrincipalToExistingBranch(@RequestParam int branchId, @RequestBody Principal principal)
	{
		return branchService.addNewPrincipalToExistingBranch(branchId, principal);
	}
	
	@PutMapping("/addExistingTeacherToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingTeacherToExistingBranch(@RequestParam int branchId, @RequestParam int teacherId)
	{
		return branchService.addExistingTeacherToExistingBranch(branchId, teacherId);
	}
	
	@PutMapping("/addNewTeacherToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewTeacherToExistingBranch(@RequestParam int branchId, @RequestBody List<Teachers> teachers)
	{
		return branchService.addNewTeacherToExistingBranch(branchId, teachers);
	}
	
	@PutMapping("/addExistingStudentToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingStudentToExistingBranch(@RequestParam int branchId, @RequestParam int studentId)
	{
		return branchService.addExistingStudentToExistingBranch(branchId, studentId);
	}
	
	@PutMapping("/addNewStudentToEistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewStudentToEistingBranch(@RequestParam int branchId, @RequestBody List<Student>students) 
	{
		return branchService.addNewStudentToEistingBranch(branchId, students);
	}
	
	@PutMapping("/addExistingFeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingFeeToExistingBranch(@RequestParam int branchId, @RequestParam int feeId)
	{
		return branchService.addExistingFeeToExistingBranch(branchId, feeId);
	}
	
	@PutMapping("/addNewFeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewFeeToExistingBranch(@RequestParam int branchId, @RequestBody List<Fees> fees)
	{
		return branchService.addNewFeeToExistingBranch(branchId, fees);
	}
	
	@PutMapping("/addExistingCourseToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingCourseToExistingBranch(@RequestParam int branchId, @RequestParam int courseId)
	{
		return branchService.addExistingCourseToExistingBranch(branchId, courseId);
	}
	
	@PutMapping("/addNewCourseToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewCourseToExistingBranch(@RequestParam int branchId, @RequestBody List<Course> courses)
	{
		return branchService.addNewCourseToExsitingBranch(branchId, courses);
	}
	
}
