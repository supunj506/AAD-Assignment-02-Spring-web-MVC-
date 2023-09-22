/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/20/2023
 * Time    : 5:33 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "project")
public class ProjectEntity implements SuperEntity {

    @Id
    private String ProjectId;
    @Column(nullable = false)
    private String companyName;
    @Column(nullable = false)
    private String companyEmail;



//
//
//    @ManyToOne
//    @JoinColumn(name = "tlId", referencedColumnName = "nic")
//    private TLEntity tlEntity;
//
//    public TLEntity getTlEntity() {return tlEntity;}
//
//    public void setTlEntity(TLEntity tlEntity) {this.tlEntity = tlEntity;}
//
//



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


}
