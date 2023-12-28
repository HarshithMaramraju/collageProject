package springBoot_CollageProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot_CollageProject.Dto.Fees;

public interface FeeRepo extends JpaRepository<Fees, Integer> {

}
