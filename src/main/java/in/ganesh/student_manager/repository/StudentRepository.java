package in.ganesh.student_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ganesh.student_manager.entity.StudentEntity;




@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
