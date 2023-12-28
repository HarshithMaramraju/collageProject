package springBoot_CollageProject.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Principal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int principalId;
	private String principalName;
	private long principalPhone;
	private double principalSalary;
	private String principalEmail;
	private String principalAddress;
	
	public int getPrincipalId() {
		return principalId;
	}
	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public long getPrincipalPhone() {
		return principalPhone;
	}
	public void setPrincipalPhone(long principalPhone) {
		this.principalPhone = principalPhone;
	}
	public double getPrincipalSalary() {
		return principalSalary;
	}
	public void setPrincipalSalary(double principalSalary) {
		this.principalSalary = principalSalary;
	}
	public String getPrincipalEmail() {
		return principalEmail;
	}
	public void setPrincipalEmail(String principalEmail) {
		this.principalEmail = principalEmail;
	}
	public String getPrincipalAddress() {
		return principalAddress;
	}
	public void setPrincipalAddress(String principalAddress) {
		this.principalAddress = principalAddress;
	}	
}
