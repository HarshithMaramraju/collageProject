package springBoot_CollageProject.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBoot_CollageProject.Dto.Branch;
import springBoot_CollageProject.Dto.Collage;
import springBoot_CollageProject.Repo.CollageRepo;

@Repository
public class CollageDao {
	
	@Autowired
	CollageRepo collageRepo;
	
	@Autowired
	BranchDao branchDao;

	public Collage insertCollage(Collage collage) {
		return collageRepo.save(collage);
	}
	
	public List<Collage> fetchAllCollage(Collage collage) 
	{
		return collageRepo.findAll();
	}
	
	public Collage fetchByIdCollage(int collageId)
	{
		Optional<Collage> collage = collageRepo.findById(collageId);
		if (collage.isPresent())
		{
			return collage.get();
		}
		else
		{
			return null;
		}
	}
	
	public Collage updateCollage(int collageId, Collage collage)
	{
		Optional<Collage> collage2 = collageRepo.findById(collageId);
		if (collage2.isPresent())
		{
			collage.setCollageId(collageId);
			return this.insertCollage(collage);
		}
		else
		{
			return null;
		}
	}
	
	public Collage delete(int collageId)
	{
		Optional<Collage> collage = collageRepo.findById(collageId);
		if (collage.isPresent())
		{
			return collage.get();
		}
		else
		{
			return null;
		}
	}
	
	public Collage addExistingBranchToExistingCollage(int collageId, int branchId)
	{
		Collage collage = collageRepo.findById(collageId).get();
		Branch branch = branchDao.findById(branchId);
		collage.getBranchs().add(branch);
		return insertCollage(collage);
	}
	
	public Collage addNewBranchToExistingCollage(int collageId, List<Branch> branch) {
//		Collage collage = collageRepo.findById(collageId).get();
//		List<Branch> list = new ArrayList<>();
//		for (Branch branch2 : list) {
//			list.add(branch2);
//		}
//		return collageRepo.save(collage);
		
		Collage collage = fetchByIdCollage(collageId);
		if (collage!=null)
		{
			List<Branch> list	= new ArrayList<>();
			for (Branch branch2 : list) {
				list.add(branch2);
			}
			collage.setBranchs(branch);
			return collageRepo.save(collage);
		}
		else
		{
			return null;
		}
	}
}
