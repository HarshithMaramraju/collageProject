package springBoot_CollageProject.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springBoot_CollageProject.Dto.Fees;
import springBoot_CollageProject.Repo.FeeRepo;

@Repository
public class FeeDao {

	@Autowired
	FeeRepo feeRepo;
	
	public Fees insert(Fees fees) {
		return feeRepo.save(fees);
	}
	
	public List<Fees> findAll(Fees fees) {
		return feeRepo.findAll();
	}
	
	public Fees findById(int feeId) {
		Optional<Fees> fees = feeRepo.findById(feeId);
		if (fees.isPresent()) {
			return fees.get();
		}
		else
		{
			return null;
		}
	}
	
	public Fees update(int feeId, Fees fees)
	{
		Optional<Fees> fees2 = feeRepo.findById(feeId);
		if (fees2.isPresent())
		{
			fees.setFeeId(feeId);
			return this.insert(fees);
		}
		else
		{
			return null;
		}
	}
	
	public Fees delete(int feesId)
	{
		Optional<Fees> fees = feeRepo.findById(feesId);
		if (fees.isPresent())
		{
			feeRepo.deleteById(feesId);
			return fees.get();
		}
		else
		{
			return null;
			
		}
	}
}
