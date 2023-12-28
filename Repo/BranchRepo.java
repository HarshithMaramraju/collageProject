package springBoot_CollageProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot_CollageProject.Dto.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer> {

}
