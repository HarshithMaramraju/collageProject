package springBoot_CollageProject.Dto;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private long branchPhone;
	private String branchEmail;
	private String branchTime;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Principal principal;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Address address;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Teachers> teachers;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Fees> fees;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Student> students;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Course> courses;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public long getBranchPhone() {
		return branchPhone;
	}

	public void setBranchPhone(long branchPhone) {
		this.branchPhone = branchPhone;
	}

	public String getBranchEmail() {
		return branchEmail;
	}

	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}

	public String getBranchTime() {
		return branchTime;
	}

	public void setBranchTime(String branchTime) {
		this.branchTime = branchTime;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teachers> teachers) {
		this.teachers = teachers;
	}

	public List<Fees> getFees() {
		return fees;
	}

	public void setFees(List<Fees> fees) {
		this.fees = fees;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", branchPhone=" + branchPhone
				+ ", branchEmail=" + branchEmail + ", branchTime=" + branchTime + ", principal=" + principal
				+ ", address=" + address + ", teachers=" + teachers + ", fees=" + fees + ", students=" + students
				+ ", courses=" + courses + "]";
	}
	
}
