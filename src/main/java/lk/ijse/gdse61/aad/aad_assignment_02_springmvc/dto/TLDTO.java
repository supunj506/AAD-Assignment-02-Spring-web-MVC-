/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/20/2023
 * Time    : 5:53 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto;


import lombok.Data;

@Data
public class TLDTO {

    private String nic;
    private String name;
    private String email;
    private String contact;

    public TLDTO() {
    }

    public TLDTO(String name, String email, String contact) {
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    public TLDTO(String nic, String name, String email, String contact) {
        this.nic = nic;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

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
}
