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

import springBoot_CollageProject.Dto.Principal;
import springBoot_CollageProject.Service.PrincipalService;
import springBoot_CollageProject.Util.ResponseStructure;

@RestController
public class PrincipalController {

	@Autowired
	PrincipalService principalService;
	
	@PostMapping("/insertPrincipal")
	public ResponseStructure<Principal> insert(Principal principal)
	{
		return principalService.insert(principal);
	}
	
	@GetMapping("/findAllPrincipal")
	public ResponseStructure<Principal> findAll(Principal principal) {
		return principalService.findAll(principal);
	}
	
	@GetMapping("/findByIdPrincipal")
	public ResponseEntity<ResponseStructure<Principal>> findById(@RequestParam int principalId) {
		return principalService.fetchById(principalId);
	}
	
	@PutMapping("/updatePrincipal")
	public ResponseEntity<ResponseStructure<Principal>> update(@RequestParam int principalId, @RequestBody Principal principal) {
		return principalService.update(principalId, principal);
	}
	
	@DeleteMapping("/deletePrincipal")
	public ResponseEntity<ResponseStructure<Principal>> delete(int principalId)
	{
		return principalService.delete(principalId);
	}
}
