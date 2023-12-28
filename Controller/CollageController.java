package springBoot_CollageProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.MediaType;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springBoot_CollageProject.Dto.Branch;
import springBoot_CollageProject.Dto.Collage;
import springBoot_CollageProject.Service.CollageService;
import springBoot_CollageProject.Util.ResponseStructure;

@RestController
public class CollageController {

	@Autowired
	CollageService collageService;
	
	@ApiOperation(value = "gym inserted", notes = "Api is used for inserted")
	@ApiResponses ({ @ApiResponse(code = 201, message = "collage saved Successfully"),
	@ApiResponse(code = 400, message = "fields cannot be null or blank"),
	@ApiResponse(code = 404, message = "method not Found")})
	@PostMapping("/insertCollage")
	public ResponseStructure<Collage> insertCollage(@RequestBody Collage collage)
	{
		return collageService.insertCollage(collage);
	}
	
	@GetMapping("/findAllCollage")
	public ResponseStructure<Collage> findAll(Collage collage)
	{
		return collageService.fetchAll(collage);
	}
	
	@GetMapping("/findByIdCollage")
	public ResponseEntity<ResponseStructure<Collage>> findById(@RequestParam int collageId)
	{
		return collageService.findById(collageId);
	}
	
	@PutMapping("/updateCollage")
//	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ResponseStructure<Collage>> update(@RequestParam int collageId, @RequestBody Collage collage)
	{
		return collageService.update(collageId, collage);
	}
	
	@DeleteMapping("/deleteCollage")
	public ResponseEntity<ResponseStructure<Collage>> delete(@RequestParam int collageId) {
		return collageService.delete(collageId);
	}
	
	@PutMapping("/addExistingBranchToExistingCollage")
	public ResponseEntity<ResponseStructure<Collage>> addExistingBranchToExistingCollage(@RequestParam int collageId, @RequestParam int branchId)
	{
		return collageService.addExistingBranchToExistingCollage(collageId, branchId);
	}
	
	@PutMapping("/addNewBranchToExistingCollage")
	public ResponseEntity<ResponseStructure<Collage>> addNewBranchToExistingCollage(@RequestParam int collageId, @RequestBody List<Branch> branch)
	{
		return collageService.addNewBranchToExistingCollage(collageId, branch);
	}
}
