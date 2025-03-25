package com.it.yaga.controller;

import com.it.yaga.dto.ProjectDTO;
import com.it.yaga.model.Dept;
import com.it.yaga.model.Project;
import com.it.yaga.repository.DeptRepository;
import com.it.yaga.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DeptRepository deptRepository;

    @GetMapping
    public String listProjects(Model model,
                               @RequestParam(required = false) String keyword,
                               @RequestParam(required = false) Long deptId,
                               @RequestParam(required = false) Character difficulty,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "5") int size) {

        Page<Project> projectPage = projectService.searchProjects(keyword, deptId, difficulty, page, size);
        List<Dept> depts = deptRepository.findAll();
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        projectPage.getContent().forEach(project -> {
            ProjectDTO projectDTO = projectService.convertEntityToDto(project);
            projectDTOS.add(projectDTO);
        });
        model.addAttribute("projects", projectDTOS);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", projectPage.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("deptId", deptId);
        model.addAttribute("difficulty", difficulty);
        model.addAttribute("depts", depts);

        return "projects";
    }


    // Trang tạo mới
    @GetMapping("/create")
    public String createForm(Model model, @ModelAttribute("projectDTO") ProjectDTO projectDTO) {
        List<Dept> depts = deptRepository.findAll();
        model.addAttribute("depts", depts);
        return "create";
    }

    // Xác nhận tạo mới
    @PostMapping("/confirm")
    public String confirmCreate(@ModelAttribute("projectDTO") ProjectDTO projectDTO, Model model) {
        String deptNm = deptRepository.findById(projectDTO.getDeptId()).get().getDeptNm();
        model.addAttribute("deptNm", deptNm);
        return "confirm-create";
    }

    // Lưu vào database
    @PostMapping("/save")
    public String saveProject(@ModelAttribute("projectDTO") ProjectDTO projectDTO) {
        Project project = new Project();
        project.setProjectNm(projectDTO.getProjectNm());
        project.setDept(deptRepository.findById(projectDTO.getDeptId()).get());
        project.setDifficulty(projectDTO.getDifficulty());
        project.setInsTm(LocalDate.now());
        project.setUpdTm(LocalDate.now());
        project.setVersion(1);

     //   projectService.saveProject(project);
        return "redirect:/projects";
    }
}
