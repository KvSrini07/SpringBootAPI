package com.intern.interns.model;

import com.intern.interns.task.entity.Task;
import jakarta.persistence.*;
import org.springframework.http.HttpStatus;

@Entity
@Table(name="intern")

public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "course")
    private String course;
@Column(name = "city")
    private String city;
@Column(name = "phoneno")
    private String phoneno;
@Column(name = "clg")
    private String clg;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    Task task;

    public UsersModel() {

    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public UsersModel(Integer id, String name, String password, String email, String course, String city, String phoneno, String clg){
        this.id=id;
        this.name=name;
        this.password=password;
        this.email=email;
        this.course=course;
        this.clg=clg;
        this.city=city;
        this.phoneno=phoneno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
    public String getClg() {
        return clg;
    }

    public void setClg(String clg) {
        this.clg = clg;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UsersModel that = (UsersModel) o;
//        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(course, that.course) && Objects.equals(city, that.city) && Objects.equals(phoneno, that.phoneno) && Objects.equals(clg, that.clg);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, password, email, course, city, phoneno, clg);
//    }

//    @Override
//    public String toString() {
//        return "UsersModel{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", course='" + course + '\'' +
//                ", city='" + city + '\'' +
//                ", phoneno='" + phoneno + '\'' +
//                ", clg='" + clg + '\'' +
//                '}';
    }
