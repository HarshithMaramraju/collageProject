package springBoot_CollageProject.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feeId;
	private double firstYearFee;
	private double firstYearBooksFee;
	private double seconfYearFee;
	private double seconfYearBooksFee;
	
	public int getFeeId() {
		return feeId;
	}
	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}
	public double getFirstYearFee() {
		return firstYearFee;
	}
	public void setFirstYearFee(double firstYearFee) {
		this.firstYearFee = firstYearFee;
	}
	public double getFirstYearBooksFee() {
		return firstYearBooksFee;
	}
	public void setFirstYearBooksFee(double firstYearBooksFee) {
		this.firstYearBooksFee = firstYearBooksFee;
	}
	public double getSeconfYearFee() {
		return seconfYearFee;
	}
	public void setSeconfYearFee(double seconfYearFee) {
		this.seconfYearFee = seconfYearFee;
	}
	public double getSeconfYearBooksFee() {
		return seconfYearBooksFee;
	}
	public void setSeconfYearBooksFee(double seconfYearBooksFee) {
		this.seconfYearBooksFee = seconfYearBooksFee;
	}

}
