/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aula2.alantodolist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author alanb
 */
@Entity
@Table(name="tasks")
@Setter
@Getter
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable=false)
    private String title;
    
    @Column(nullable=false)
    private String description;
    
    @Column(nullable=false)
    private LocalDateTime deadLine;
    
    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable= false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name= "update_at")
    private LocalDateTime updatedAt;
}
