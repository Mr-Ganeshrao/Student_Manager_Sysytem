package in.ganesh.student_manager.service;

import java.util.List;

import in.ganesh.student_manager.entity.StudentEntity;

public interface StudentService {
	
	
	public String upsert(StudentEntity studentEntity);
	public List<StudentEntity> getAll();
	public StudentEntity getRecord(int stud_id);
	public String deleteRecord(int Stud_id);

}
