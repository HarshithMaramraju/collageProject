package springBoot_CollageProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot_CollageProject.Dto.Teachers;

public interface TeachersRepo extends JpaRepository<Teachers, Integer> {

}
