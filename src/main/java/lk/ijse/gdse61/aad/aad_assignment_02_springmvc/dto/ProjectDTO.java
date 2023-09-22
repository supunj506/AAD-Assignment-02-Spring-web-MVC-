/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/20/2023
 * Time    : 5:53 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.time.LocalDate;

@Data
public class ProjectDTO {
    private String ProjectId;
    private String companyName;
    private String companyEmail;
    private String tlId;

    public ProjectDTO() {
    }

    public ProjectDTO(String projectId, String companyName, String companyEmail,String tlId) {
        this.ProjectId = projectId;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.tlId=tlId;
    }


    public ProjectDTO(String companyName, String companyEmail,String tlId) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.tlId=tlId;
    }


    public String getProjectId() {
        return ProjectId;
    }

    public void setProjectId(String projectId) {
        ProjectId = projectId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getTlId() {return tlId;}

    public void setTlId(String tlId) {this.tlId = tlId;}
}
