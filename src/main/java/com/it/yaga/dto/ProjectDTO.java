package com.it.yaga.dto;

import java.time.LocalDate;

public class ProjectDTO {
    private int projectId;
    private String projectNm;
    private Integer deptId;
    private String deptNm;
    private Character difficulty;
    private LocalDate insTm;
    private LocalDate updTm;
    private Integer version;


    public ProjectDTO(){}
    // Constructor
    public ProjectDTO(int projectId, String projectNm, String deptNm, Character difficulty, LocalDate insTm, LocalDate updTm, Integer version) {
        this.projectId = projectId;
        this.projectNm = projectNm;
        this.deptNm = deptNm;
        this.difficulty = difficulty;
        this.insTm = insTm;
        this.updTm = updTm;
        this.version = version;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectNm() {
        return projectNm;
    }

    public void setProjectNm(String projectNm) {
        this.projectNm = projectNm;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public Character getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Character difficulty) {
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
