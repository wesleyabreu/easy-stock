package com.MotoCode.projeto.StudentController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MotoCode.projeto.StudentDAO.Dao;
import com.MotoCode.projeto.StudentModel.StudentModel;

@RestController
@CrossOrigin("*")                           // Importante
@RequestMapping
public class StudentController {

    @Autowired  // Injection que permite com que "dao" receba TUDO que está na Interface do CRUD mesmo SEM IMPLEMENTAR
    private Dao dao;
    
    // Listar os Students
    @GetMapping("/students")    // URL identifier
    public List<StudentModel> listarStudents(){
        return (List<StudentModel>) dao.findAll();
    }

    // Criando Students
    @PostMapping
    public StudentModel criarStudent(@RequestBody StudentModel student){
        StudentModel studentNovo = dao.save(student);
        return studentNovo;
    }

    // Modificando Students
    @PutMapping
    public StudentModel modificarStudent(@RequestBody StudentModel student){
        StudentModel studentNovo = dao.save(student);
        return studentNovo;
    }

    @DeleteMapping("/{id}") // Rota para fazer o delete
    public Optional<StudentModel> excluirStudent(@PathVariable Integer id){
        Optional<StudentModel> usuarioAserDeletado = dao.findById(id);
        dao.deleteById(id);
        return usuarioAserDeletado;
    }
}

