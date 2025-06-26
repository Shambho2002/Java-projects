package com.sjprogramming.bankapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjprogramming.bankapp.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
