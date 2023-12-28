package springBoot_CollageProject.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private String studentDOB;
	private long studentPhone;
	private String studentFatherName;
	private long studentFatherPhone;
	private String studentAddress;
	private String studentCourse;
	private String studentyear;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(String studentDOB) {
		this.studentDOB = studentDOB;
	}
	public long getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(long studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentFatherName() {
		return studentFatherName;
	}
	public void setStudentFatherName(String studentFatherName) {
		this.studentFatherName = studentFatherName;
	}
	public long getStudentFatherPhone() {
		return studentFatherPhone;
	}
	public void setStudentFatherPhone(long studentFatherPhone) {
		this.studentFatherPhone = studentFatherPhone;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentCourse() {
		return studentCourse;
	}
	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}
	public String getStudentyear() {
		return studentyear;
	}
	public void setStudentyear(String studentyear) {
		this.studentyear = studentyear;
	}
}
