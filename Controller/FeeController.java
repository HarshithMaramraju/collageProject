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

import springBoot_CollageProject.Dto.Fees;
import springBoot_CollageProject.Service.FeeService;
import springBoot_CollageProject.Util.ResponseStructure;

@RestController
public class FeeController
{
	@Autowired
	FeeService feeService;
	
	@PostMapping("/insertFees")
	public ResponseStructure<Fees> insert(@RequestBody Fees fees)
	{
		return feeService.insert(fees);
	}
	
	@GetMapping("/findAllFees")
	public ResponseStructure<Fees> findAll(Fees fees)
	{
		return feeService.findAll(fees);
	}
	
	@GetMapping("/findByIdFees")
	public ResponseEntity<ResponseStructure<Fees>> findById(@RequestParam int feeId)
	{
		return feeService.findById(feeId);
	}
	
	@PutMapping("/updateFees")
	public ResponseEntity<ResponseStructure<Fees>> update(@RequestParam int feeId, @RequestBody Fees fees)
	{
		return feeService.update(feeId, fees);
	}
	
	@DeleteMapping("/deleteFees")
	public ResponseEntity<ResponseStructure<Fees>> delete(@RequestParam int feeId)
	{
		return feeService.delete(feeId);
	}
}
