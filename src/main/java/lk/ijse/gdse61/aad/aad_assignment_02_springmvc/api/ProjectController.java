/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/21/2023
 * Time    : 3:56 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.api;

import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto.ProjectDTO;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto.TLDTO;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.services.ProjectService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ProjectDTO saveProject(
            @RequestPart String id,
            @RequestPart String comName,
            @RequestPart String comEmail,
            @RequestPart String tlId
    ){
        if(id==null){
            throw new RuntimeException("Invalid Id");
        } else if (comName==null) {
            throw new RuntimeException("Invalid name");
        } else if (comEmail==null) {
            throw new RuntimeException("Invalid email");
        }else if (tlId==null){
            throw new RuntimeException("Invalid tech lead id");
        }
        return projectService.saveProject(new ProjectDTO(id,comName,comEmail,tlId));

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping( "{id}")
    void updateProject(@PathVariable String id,
                  @RequestPart String comName,
                  @RequestPart String comEmail,
                  @RequestPart String tlId){
        if(id==null){
            throw new RuntimeException("Invalid id");
        } else if (comName==null) {
            throw new RuntimeException("Invalid name");
        } else if (comEmail==null) {
            throw new RuntimeException("Invalid Email");
        }else if (tlId==null){
            throw new RuntimeException("Invalid tech lead id");
        }
        projectService.updateProject(id,new ProjectDTO(comName,comEmail,tlId));
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void deleteProject(@PathVariable String id){
        if(id==null) throw new RuntimeException("NIC is invalid");
        projectService.deleteProject(id);
    }



    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ProjectDTO getProject(@PathVariable String id){
        if(id==null) throw new RuntimeException("NIC is invalid");
        return projectService.getProjectById(id);
    }
}
