package in.ganesh.student_manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Student_INFO")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stud_Id")
	private int id;
	
	@Column(name = "stud_Name")
	private String name;
	
	@Column(name="stud_Email")
	private String email;
	
	@Column(name="stud_Phno")
	private long phno;
	
	@Column(name="status")
	private String activeSw;

}
