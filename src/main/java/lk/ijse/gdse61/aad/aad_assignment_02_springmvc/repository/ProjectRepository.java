/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/22/2023
 * Time    : 11:48 AM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.repository;

import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity,String> {
//    ProjectEntity findByProjectId(String id);
}
