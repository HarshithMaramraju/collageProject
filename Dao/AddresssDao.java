package springBoot_CollageProject.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBoot_CollageProject.Dto.Address;
import springBoot_CollageProject.Repo.AddressRepo;

@Repository
public class AddresssDao {

	@Autowired
	AddressRepo addressRepo;
	
	public Address insert(Address address)
	{
		return addressRepo.save(address);
	}
	
	public List<Address> findAll(Address address) {
		
		return addressRepo.findAll();	
	}
	
	public Address findById(int addressId)
	{
		Optional<Address> address = addressRepo.findById(addressId);
		if (address.isPresent()) {
			return address.get();
		}
		else {
			return null;
		}
	}
	
	public Address update(int addressId, Address address)
	{
		Optional<Address> address2 = addressRepo.findById(addressId);
		if (address2.isPresent()) 
		{
			address.setAddressId(addressId);
			return this.insert(address);
		}
		else {
			return null;
		}
	}
	public Address delete(int addressId)
	{
		Optional<Address> address = addressRepo.findById(addressId);
		if (address.isPresent())
		{
			addressRepo.deleteById(addressId);
			return address.get();
		}
		else {
			return null;
		}
	}
}
