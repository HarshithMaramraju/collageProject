package springBoot_CollageProject.Controller;

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
import springBoot_CollageProject.Service.AddressService;
import springBoot_CollageProject.Util.ResponseStructure;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/insertAddress")
	public ResponseStructure<Address> insert(@RequestBody Address address)
	{
		return addressService.insert(address);
	}
	
	@GetMapping("/findAllAddress")
	public ResponseStructure<Address> findAll(Address address)
	{
		return addressService.findAll(address);
	}
	
	@GetMapping("/findByIdAddress")
	public ResponseEntity<ResponseStructure<Address>> findById(@RequestParam int addressId)
	{
		return addressService.findById(addressId);
	}
	
	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseStructure<Address>> update(@RequestParam int addressId, @RequestBody Address address)
	{
		return addressService.update(addressId, address);
	}
	
	@DeleteMapping("/deleteAddress")
	public ResponseEntity<ResponseStructure<Address>> delete(@RequestParam int addressId)
	{
		return addressService.delete(addressId);
	}
}
