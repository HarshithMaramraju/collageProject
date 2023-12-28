package springBoot_CollageProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springBoot_CollageProject.Dao.FeeDao;
import springBoot_CollageProject.Dto.Fees;
import springBoot_CollageProject.ExceptionHandiling.FeeIdNotFound;
import springBoot_CollageProject.Util.ResponseStructure;

@Service
public class FeeService {

	@Autowired
	FeeDao feeDao;
	
	public ResponseStructure<Fees> insert(Fees fees)
	{
		ResponseStructure<Fees> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("inserted success");
		responseStructure.setData(feeDao.insert(fees));
		return responseStructure;
	}
	
	public ResponseStructure<Fees> findAll(Fees fees)
	{
		ResponseStructure<Fees> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("fetch success");
		responseStructure.setDatas(feeDao.findAll(fees));
		return responseStructure;
	}
	
	public ResponseEntity<ResponseStructure<Fees>> findById(int feeId)
	{
		ResponseStructure<Fees> responseStructure = new ResponseStructure<>();
		Fees fees = feeDao.findById(feeId);
		if (fees!=null)
		{
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("fetch successfull");
			responseStructure.setData(feeDao.findById(feeId));
			return new ResponseEntity<ResponseStructure<Fees>>(responseStructure, HttpStatus.FOUND);
		}
		else
		{
			throw new FeeIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Fees>> update(int feeId, Fees fees)
	{
		ResponseStructure<Fees> responseStructure = new ResponseStructure<>();
		Fees fees2 = feeDao.update(feeId, fees);
		if (fees2!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated successfull");
			responseStructure.setData(feeDao.update(feeId, fees2));
			return new ResponseEntity<ResponseStructure<Fees>>(responseStructure, HttpStatus.OK);
		}
		else
		{
			throw new FeeIdNotFound();
		}
	}
	
	public ResponseEntity<ResponseStructure<Fees>> delete(int feeId)
	{
		ResponseStructure<Fees> responseStructure = new ResponseStructure<>();
		Fees fees = feeDao.delete(feeId);
		if (fees!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("delete successfull");
			responseStructure.setData(feeDao.delete(feeId));
			return new ResponseEntity<ResponseStructure<Fees>>(responseStructure, HttpStatus.OK);
		}
		else
		{
			throw new FeeIdNotFound();
		}
	}
}
