package springBoot_CollageProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot_CollageProject.Dto.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
