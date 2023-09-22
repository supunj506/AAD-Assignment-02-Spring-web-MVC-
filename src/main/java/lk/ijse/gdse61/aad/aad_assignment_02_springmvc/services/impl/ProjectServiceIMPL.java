/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/21/2023
 * Time    : 3:51 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.services.impl;

import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto.ProjectDTO;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.entity.ProjectEntity;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.entity.TLEntity;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.repository.ProjectRepository;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.services.ProjectService;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProjectServiceIMPL implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    Converter converter;

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        ProjectEntity projectEntity = converter.getProjectEntity(projectDTO);
        projectRepository.save(projectEntity);
        return projectDTO;
    }

    @Override
    public void updateProject(String id, ProjectDTO projectDTO) {
        Optional<ProjectEntity> tempProject = projectRepository.findById(id);
        if(!tempProject.isPresent())throw new RuntimeException("Not Fount Project in Database");
        tempProject.get().setCompanyName(projectDTO.getCompanyName());
        tempProject.get().setCompanyEmail(projectDTO.getCompanyEmail());
//        tempProject.get().(projectDTO.getCompanyEmail());
    }

    @Override
    public void deleteProject(String id) {

        if(!projectRepository.existsById(id)) throw new RuntimeException("Not found project in database");
        projectRepository.deleteById(id);

    }

    @Override
    public ProjectDTO getProjectById(String id) {
        if(!projectRepository.existsById(id)) throw new RuntimeException("Not found project in database");
//        return converter.getProjectDTO(projectRepository.findByProjectId(id));
        ProjectEntity byId = projectRepository.getById(id);
        return converter.getProjectDTO(byId);
    }
}
