package com.it.yaga.repository;

import com.it.yaga.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Page<Project> findByProjectNmContaining(String projectNm, Pageable pageable);

    @Query(value = "SELECT * FROM project p WHERE " +
            "(:projectNm IS NULL OR p.project_nm LIKE CONCAT('%', :projectNm, '%')) AND " +
            "(:deptId IS NULL OR p.dept_id = :deptId) AND " +
            "(:difficulty IS NULL OR p.difficulty = :difficulty)",
            countQuery = "SELECT COUNT(*) FROM project p WHERE " +
                    "(:projectNm IS NULL OR p.project_nm LIKE CONCAT('%', :projectNm, '%')) AND " +
                    "(:deptId IS NULL OR p.dept_id = :deptId) AND " +
                    "(:difficulty IS NULL OR p.difficulty = :difficulty)",
            nativeQuery = true)
    Page<Project> searchProjects(@Param("projectNm") String projectNm,
                                 @Param("deptId") Integer deptId,  // Dùng Integer thay vì int
                                 @Param("difficulty") Character difficulty,
                                 Pageable pageable);


}