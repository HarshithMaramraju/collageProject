package springBoot_CollageProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot_CollageProject.Dto.Principal;

public interface PrincipalRepo extends JpaRepository<Principal, Integer> {

}
