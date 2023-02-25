package com.akashSpringLearning.springpractice.StudentRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akashSpringLearning.springpractice.StudentModel.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> 
{

}
