/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aula2.alantodolist.service;

import com.aula2.alantodolist.model.Task;
import com.aula2.alantodolist.repository.TaskRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author alanb
 */
@Service
@RequiredArgsConstructor
public class Taskservice {
    @Autowired
    private TaskRepository taskRepository;
    
    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    
    public List<Task> listAllTasks(){
        return taskRepository.findAll();
    }
    
    public ResponseEntity<Task> findTaskById(long id){
        return taskRepository.findById(id)
        .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }
    
    public ResponseEntity<Task> updateTaskById(Task task, long id ){
        return taskRepository.findById(id)
                .map(taskToUpdate ->{
                    taskToUpdate.setTitle(task.getTitle());
                    taskToUpdate.setDescription(task.getDescription());
                    taskToUpdate.setDeadLine(task.getDeadLine());
                    Task updated = taskRepository.save(taskToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    public ResponseEntity<Object> deleteById(long id){
        return taskRepository.findById(id)
                .map(taskToDelete ->{
                    taskRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                    
                }).orElse(ResponseEntity.notFound().build());
    }
}
