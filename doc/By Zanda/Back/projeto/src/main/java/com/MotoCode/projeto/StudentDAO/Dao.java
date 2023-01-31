package com.MotoCode.projeto.StudentDAO;

import org.springframework.data.repository.CrudRepository;

import com.MotoCode.projeto.StudentModel.StudentModel;

public interface Dao extends CrudRepository<StudentModel, Integer> {
    
}
