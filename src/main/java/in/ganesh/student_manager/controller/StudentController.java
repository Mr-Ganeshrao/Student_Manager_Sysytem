package in.ganesh.student_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ganesh.student_manager.entity.StudentEntity;
import in.ganesh.student_manager.service.StudentServiceImplementation;

@RestController
public class StudentController {

	@Autowired
	StudentServiceImplementation serviceImplementation;
	

	@PostMapping("/student")
	public ResponseEntity<String> upsert(@RequestBody StudentEntity entity) {
		String string = serviceImplementation.upsert(entity);
		
		return new ResponseEntity<String>(string, HttpStatus.ACCEPTED);
	}
	

	@GetMapping("/students")
	public ResponseEntity<List<StudentEntity>> getAll() {
		List<StudentEntity> records = serviceImplementation.getAll();

		return new ResponseEntity<>(records, HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<StudentEntity> getRecord(@PathVariable int id){
		StudentEntity studentEntity=serviceImplementation.getRecord(id);
		return new ResponseEntity<>(studentEntity,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteRecord(@PathVariable int id){
		String string=serviceImplementation.deleteRecord(id);
		return new ResponseEntity<>(string,HttpStatus.OK);
		
	}

}
