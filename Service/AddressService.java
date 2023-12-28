package springBoot_CollageProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springBoot_CollageProject.Dao.AddresssDao;
import springBoot_CollageProject.Dto.Address;
import springBoot_CollageProject.ExceptionHandiling.AddressIdNotFound;
import springBoot_CollageProject.Util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	AddresssDao addresssDao;
	
	public ResponseStructure<Address> insert(Address address) {
	
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("inserted success");
		responseStructure.setData(addresssDao.insert(address));
		return responseStructure;
	}
	
	public ResponseStructure<Address> findAll(Address address) {
		
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("fetch success");
		responseStructure.setDatas(addresssDao.findAll(address));
		return responseStructure;
	}
	
	public ResponseEntity<ResponseStructure<Address>> findById(int addressId) {
		
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		Address address = addresssDao.findById(addressId);
		if (address!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("fetch success");
			responseStructure.setData(addresssDao.findById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);			
		}
		else
		{
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> update(int addressId, Address address) {
		
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		Address address2 = addresssDao.update(addressId, address);
		if (address2!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("update success");
			responseStructure.setData(addresssDao.update(addressId, address));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);			
		}
		else
		{
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> delete(int addressId) {
		
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		Address address = addresssDao.delete(addressId);
		if (address!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("delete success");
			responseStructure.setData(addresssDao.delete(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);			
		}
		else
		{
			throw new AddressIdNotFound();
		}
	}
}
