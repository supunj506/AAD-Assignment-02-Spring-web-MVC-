/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/20/2023
 * Time    : 5:31 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tech_lead")
public class TLEntity implements SuperEntity {
    @Id
    String nic;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String contact;

    @OneToMany(mappedBy = "tech_lead",cascade = CascadeType.ALL)
    private List<ProjectEntity> projectEntityList;

//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
//    private List<Project> projectList;


    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<ProjectEntity> getProjectEntityList() {
        return projectEntityList;
    }

    public void setProjectEntityList(List<ProjectEntity> projectEntityList) {
        this.projectEntityList = projectEntityList;
    }
}
