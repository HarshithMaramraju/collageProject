package springBoot_CollageProject.Dto;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Collage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collageId;
	
//	@NotNull(message = "section cant be null")
//	@NotBlank(message = "section cant be blank")
	private String collageName;
	
//	@NotNull(message = "section cant be null")
//	@NotBlank(message = "section cant be blank")
	private String collageFounderName;
	
//	@NotNull(message = "section cant be null")
//	@NotBlank(message = "section cant be blank")
	private String	collageCode;
	
//	@Min(value = 7000000000l)
//	@Max(value = 9000000000l)
	private long collagephone;
	
//	@NotNull(message = "section cant be null")
//	@NotBlank(message = "section cant be blank")
	private String collageAddress;
	
//	@NotNull(message = "section cant be null")
//	@NotBlank(message = "section cant be blank")
	private String collageWebsite;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Branch> branchs;

	public int getCollageId() {
		return collageId;
	}

	public void setCollageId(int collageId) {
		this.collageId = collageId;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	public String getCollageFounderName() {
		return collageFounderName;
	}

	public void setCollageFounderName(String collageFounderName) {
		this.collageFounderName = collageFounderName;
	}

	public String getCollageCode() {
		return collageCode;
	}

	public void setCollageCode(String collageCode) {
		this.collageCode = collageCode;
	}

	public long getCollagephone() {
		return collagephone;
	}

	public void setCollagephone(long collagephone) {
		this.collagephone = collagephone;
	}

	public String getCollageAddress() {
		return collageAddress;
	}

	public void setCollageAddress(String collageAddress) {
		this.collageAddress = collageAddress;
	}

	public String getCollageWebsite() {
		return collageWebsite;
	}

	public void setCollageWebsite(String collageWebsite) {
		this.collageWebsite = collageWebsite;
	}

	public List<Branch> getBranchs() {
		return branchs;
	}

	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}

	@Override
	public String toString() {
		return "Collage [collageId=" + collageId + ", collageName=" + collageName + ", collageFounderName="
				+ collageFounderName + ", collageCode=" + collageCode + ", collagephone=" + collagephone
				+ ", collageAddress=" + collageAddress + ", collageWebsite=" + collageWebsite + ", branchs=" + branchs
				+ "]";
	}
	
	
}
