package springBoot_CollageProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot_CollageProject.Dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
