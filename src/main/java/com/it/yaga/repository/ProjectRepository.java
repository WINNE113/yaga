package com.it.yaga.repository;

import com.it.yaga.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Page<Project> findByProjectNmContaining(String projectNm, Pageable pageable);

    @Query("SELECT p FROM Project p WHERE " +
            "(:projectNm IS NULL OR p.projectNm LIKE %:projectNm%) AND " +
            "(:deptId IS NULL OR p.dept.deptId = :deptId) AND " +
            "(:difficulty IS NULL OR p.difficulty = :difficulty)")
    Page<Project> searchProjects(@Param("projectNm") String projectNm,
                                 @Param("deptId") Long deptId,
                                 @Param("difficulty") Character difficulty,
                                 Pageable pageable);
}