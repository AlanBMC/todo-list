/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aula2.alantodolist.Controller;

import com.aula2.alantodolist.model.Task;
import com.aula2.alantodolist.service.Taskservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class TaskController {
    
    @Autowired
    Taskservice taskService;
    
    
    @PostMapping("/Task")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }   
    
    
    @GetMapping("/Task")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        return taskService.listAllTasks();
    }

    

    @GetMapping("/Task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable (value= "id")long id){
        return taskService.findTaskById(id);
        
    }

    @PutMapping("/Task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTaskById(@PathVariable (value= "id")long id, @RequestBody Task task){
        return taskService.updateTaskById(task, id);
        
    }
    
   
    @DeleteMapping("/Task/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById(@PathVariable (value= "id")long id){
        return taskService.deleteById(id);
        
    }
}
