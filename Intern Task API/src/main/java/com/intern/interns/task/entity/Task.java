package com.intern.interns.task.entity;
import com.intern.interns.model.UsersModel;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="intern_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String taskdes;

    @Column
    String name;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "submitted_time", updatable = false)
    private Date submitted_time;

    public Long getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getTaskdes() {
        return taskdes;
    }

    public void setTaskdes(String taskdes) {
        this.taskdes = taskdes;
    }


    public Date getSubmitted_time() {
        return submitted_time;
    }

    public void setSubmitted_time(Date submitted_time) {
        this.submitted_time = submitted_time;
    }


}