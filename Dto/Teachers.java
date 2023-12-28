package springBoot_CollageProject.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import lombok.Data; 

//@Data
@Entity
public class Teachers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacheerId;
	private String teacherName;
	private int teacherAge;
	private String teacherSubject;
	private double teacherSalary;
	private String teacherExperience;
	private String teacherAddress;
	private long teacherPhone;
	
	public int getTeacheerId() {
		return teacheerId;
	}
	public void setTeacheerId(int teacheerId) {
		this.teacheerId = teacheerId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getTeacherAge() {
		return teacherAge;
	}
	public void setTeacherAge(int teacherAge) {
		this.teacherAge = teacherAge;
	}
	public String getTeacherSubject() {
		return teacherSubject;
	}
	public void setTeacherSubject(String teacherSubject) {
		this.teacherSubject = teacherSubject;
	}
	public double getTeacherSalary() {
		return teacherSalary;
	}
	public void setTeacherSalary(double teacherSalary) {
		this.teacherSalary = teacherSalary;
	}
	public String getTeacherExperience() {
		return teacherExperience;
	}
	public void setTeacherExperience(String teacherExperience) {
		this.teacherExperience = teacherExperience;
	}
	public String getTeacherAddress() {
		return teacherAddress;
	}
	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}
	public long getTeacherPhone() {
		return teacherPhone;
	}
	public void setTeacherPhone(long teacherPhone) {
		this.teacherPhone = teacherPhone;
	}
}
