package com.it.yaga.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private String projectNm;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Dept dept;

    private char difficulty;
    private LocalDate insTm;
    private LocalDate updTm;
    private Integer version;

    @PrePersist
    protected void onCreate() {
        this.insTm = LocalDate.now();
        this.updTm = LocalDate.now();
        this.version = 1;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updTm = LocalDate.now();
        this.version += 1;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectNm() {
        return projectNm;
    }

    public void setProjectNm(String projectNm) {
        this.projectNm = projectNm;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public char getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(char difficulty) {
        this.difficulty = difficulty;
    }

    public LocalDate getInsTm() {
        return insTm;
    }

    public void setInsTm(LocalDate insTm) {
        this.insTm = insTm;
    }

    public LocalDate getUpdTm() {
        return updTm;
    }

    public void setUpdTm(LocalDate updTm) {
        this.updTm = updTm;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
