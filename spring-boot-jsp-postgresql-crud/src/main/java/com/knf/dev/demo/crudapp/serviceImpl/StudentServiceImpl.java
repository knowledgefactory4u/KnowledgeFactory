package com.knf.dev.demo.crudapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.knf.dev.demo.crudapp.dto.StudentDTO;
import com.knf.dev.demo.crudapp.model.Student;
import com.knf.dev.demo.crudapp.repository.StudentRepository;
import com.knf.dev.demo.crudapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public void createOrUpdateStudent(StudentDTO studentDTO) {
		Student student = convertDtoToModel(studentDTO);
		studentRepository.save(student);
	}
	
	public List<StudentDTO> getAllStudent() {
		List<Student> list = studentRepository.findAll();
		List<StudentDTO> userList = list.stream()
	            .map(StudentDTO::new)
	            .collect(Collectors.toCollection(ArrayList::new));
		return userList;
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
	public StudentDTO editStudent(Long id) {
		Student student = studentRepository.getReferenceById(id);
		return convertModelToDTO(student);
	}
	
	private Student convertDtoToModel(StudentDTO userDto) {
		Student student = new Student();
		if (userDto.getId() != null) {
			student.setId(userDto.getId());
		}
		student.setEmailId(userDto.getEmailId());
		student.setFirstName(userDto.getFirstName());
		student.setLastName(userDto.getLastName());
		return student;
	}
	
	private StudentDTO convertModelToDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(student.getId());
		studentDTO.setEmailId(student.getEmailId());
		studentDTO.setFirstName(student.getFirstName());
		studentDTO.setLastName(student.getLastName());
		return studentDTO;
	}
}
