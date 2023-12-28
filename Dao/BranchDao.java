package springBoot_CollageProject.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBoot_CollageProject.Dto.Address;
import springBoot_CollageProject.Dto.Branch;
import springBoot_CollageProject.Dto.Course;
import springBoot_CollageProject.Dto.Fees;
import springBoot_CollageProject.Dto.Principal;
import springBoot_CollageProject.Dto.Student;
import springBoot_CollageProject.Dto.Teachers;
import springBoot_CollageProject.Repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	AddresssDao addresssDao;
	
	@Autowired
	PrincipalDao principalDao;
	
	@Autowired
	TeacherDao teacherDao;
	
	@Autowired
	FeeDao feeDao;
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	CourseDao courseDao;
	
	public Branch insert(Branch branch)
	{
		return branchRepo.save(branch);
	}
	
	public List<Branch> findAll(Branch branch)
	{
		return branchRepo.findAll();
	}
	
	public Branch findById(int branchId)
	{
		Optional<Branch> branch = branchRepo.findById(branchId);
		if (branch.isPresent()) {
			return  branch.get();
		}
		else
		{
			return null;
		}
	}
	
	public Branch update(int branchId, Branch branch)
	{
		Optional<Branch> branch2 = branchRepo.findById(branchId);
		if (branch2.isPresent())
		{
			branch.setBranchId(branchId);
			return this.insert(branch);
		}
		else
		{
			return null;
		}
	}
	
	public Branch delete(int branchId)
	{
		Optional<Branch> branch = branchRepo.findById(branchId);
		if (branch.isPresent())
		{
			branchRepo.deleteById(branchId);
			return branch.get();
		}
		else
		{
			return null;
		}
	}
	
	public Branch addExistingAddressToExistingCollage(int branchId, int addressId) 
	{
		Branch branch = branchRepo.findById(branchId).get();
		Address address = addresssDao.findById(addressId);
		branch.setAddress(address);
		return insert(branch);
	}
		
	public Branch addNewAddressToExistingBranch(int branchId, Address address)
	{
		Branch branch = branchRepo.findById(branchId).get();
		branch.setAddress(address);
		return insert(branch);
	}
	
	public Branch addExistingPrincipalToExistingBranch(int branchId, int principalId)
	{
		Branch branch = branchRepo.findById(branchId).get();
		Principal principal = principalDao.findById(principalId);
		branch.setPrincipal(principal);
		return insert(branch);
	}
	
	public Branch addNewPrincipalToExistingBranch(int branchId, Principal principal)
	{
		Branch branch = branchRepo.findById(branchId).get();
		branch.setPrincipal(principal);
		return insert(branch);
	}
	
	public Branch addExistingTeacherToExistingBranch(int branchId, int teacherId)
	{
		Branch branch = branchRepo.findById(branchId).get();
		Teachers teachers = teacherDao.findById(teacherId);
		branch.getTeachers().add(teachers);
		return insert(branch);
	}
	
	public Branch addNewTeacherToExistingBranch(int branchId, List<Teachers> teachers)
	{
//		Branch branch = branchRepo.findById(branchId).get();
		Branch branch = findById(branchId);
		if (branch!=null) {
			List<Teachers> list = new ArrayList<>();
			for (Teachers teachers2 : list) {
				list.add(teachers2);			
		}
		}
		branch.setTeachers(teachers);
		return branchRepo.save(branch);
	}
	
	public Branch addExistingStudentToExistingBranch(int branchId, int studentId)
	{
		Branch branch = branchRepo.findById(branchId).get();
		Student student = studentDao.findById(studentId);
		branch.getStudents().add(student);
		return insert(branch);
	}
	
	public Branch addNewStudentToEistingBranch(int branchId, List<Student> students) {
		Branch branch = branchRepo.findById(branchId).get();
		List<Student> list = new ArrayList<>();
		for (Student student : list) {
			list.add(student);
		}
		branch.setStudents(students);
		return branchRepo.save(branch);
	}
	
	public Branch addExistingFeeToExistingBranch(int branchId, int feeId)
	{
		Branch branch =  branchRepo.findById(branchId).get();
		Fees fees = feeDao.findById(feeId);
		branch.getFees().add(fees);
		return insert(branch);
	}
	
	public Branch addNewFeeToExistingBranch(int branchId, List<Fees> fees)
	{
//		 Branch branch = branchRepo.findById(branchId).get();
//		 List<Fees> list = new ArrayList<>();
//		 for (Fees fees2 : list) {
//			list.add(fees2);
//		}
//		 branch.setFees(list);
//		 return branchRepo.save(branch);
		
		Branch branch = findById(branchId);
		if (branch!=null) {
			List<Fees>list = new ArrayList<>();
			for (Fees fees2 : list) {
				list.add(fees2);
			}
			branch.setFees(fees);
			return branchRepo.save(branch);
		}
		else
		{
			return null;
		}
	}
	
	public Branch addExistingCourseToExistingBranch(int branchId, int courseId)
	{
		Branch branch = branchRepo.findById(branchId).get();
		Course course = courseDao.findById(courseId);
		branch.getCourses().add(course);
		return insert(branch);
	}
	
	public Branch addNewCourseToExistingbranch(int branchId, List<Course> courses)
	{
		Branch branch = branchRepo.findById(branchId).get();
		List<Course> list = new ArrayList<>();
		for (Course course : list) {
			list.add(course);
		}
		branch.setCourses(courses);
		return branchRepo.save(branch);
	}
}
