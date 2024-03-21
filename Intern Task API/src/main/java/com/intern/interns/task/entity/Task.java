package com.intern.interns.task.entity;
import com.intern.interns.model.UsersModel;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="intern_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;
    @Column(name = "taskdes", nullable = false)
    private String taskdes;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "submitted_time")
    private Date submitted_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Task(String taskdes){
    this.taskdes=taskdes;
}
public Task(){

}

}