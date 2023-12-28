package springBoot_CollageProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot_CollageProject.Dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
