package springBoot_CollageProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot_CollageProject.Dto.Collage;

public interface CollageRepo extends JpaRepository<Collage, Integer> {

}
