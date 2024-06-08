package in.ganesh.student_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ganesh.student_manager.entity.StudentEntity;
import in.ganesh.student_manager.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public String upsert(StudentEntity studentEntity) {
		studentEntity.setActiveSw("Y");
		StudentEntity record = repository.save(studentEntity);
		if (record != null) {
			return "Record Inserted Succefully!!!!";
		} else {
			return "Something went wrong!!!!";
		}
	}

	@Override
	public List<StudentEntity> getAll() {
		List<StudentEntity> entities = repository.findAll();
		return entities;
	}

	@Override
	public StudentEntity getRecord(int stud_id) {

		Optional<StudentEntity> entity = repository.findById(stud_id);
		StudentEntity entity2 = entity.get();
		if (entity2.getActiveSw() != "N") {
			if (entity.isPresent()) {

				return entity.get();
			} else {

				return null;
			}
		}
		return null;
	}

	@Override
	public String deleteRecord(int Stud_id) {

		Optional<StudentEntity> optional = repository.findById(Stud_id);
		if (optional.isPresent()) {
			StudentEntity entity=optional.get();
			entity.setActiveSw("N");
			repository.save(entity);
			
		}
		return "Record deleted Succefully!!!!";
	}

}
