/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/21/2023
 * Time    : 3:48 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.services;

import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto.ProjectDTO;

public interface ProjectService {
    ProjectDTO saveProject(ProjectDTO projectDTO);
    void updateProject(String id,ProjectDTO projectDTO);
    void deleteProject(String id);
    ProjectDTO getProjectById(String id);
}
