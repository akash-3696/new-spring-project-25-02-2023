package com.akashSpringLearning.springpractice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akashSpringLearning.springpractice.StudentModel.StudentModel;
import com.akashSpringLearning.springpractice.StudentRepo.StudentRepository;

@RestController
@RequestMapping("/avi/v1")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/home")
	public String home(){
		return "Welcom!!";
	}
	
	@GetMapping("/Student")
	public String hello() {
		return "Hello World!!";
	}
	@GetMapping("/allStudents")
	public List<StudentModel> getStudents(){
		return studentRepository.findAll();
	}
	@GetMapping("/getstudent/{Id}")
	@ResponseBody
	public Optional<StudentModel> getbyId(@PathVariable("Id") Long Id) {
		return studentRepository.findById(Id);
	}
	
	@PostMapping("/addStudent")
	public StudentModel addStudent(@RequestBody StudentModel studEntity){	
		return studentRepository.save(studEntity);
	}
	
	@DeleteMapping("/getstudent/{Id}")
	@ResponseBody
	public String delbyId(@PathVariable("Id") Long Id) {
		Optional<StudentModel> studModel1 = studentRepository.findById(Id);
		studentRepository.deleteById(Id);
		return "Deleted";
	}
	
	@GetMapping("/user")
	public String user(){
		return "Hi User";
	}
	@GetMapping("/Admin")
	public String admin(){
		return "Hi Admin";
	}
	
	
}
