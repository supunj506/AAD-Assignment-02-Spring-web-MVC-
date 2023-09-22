/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/20/2023
 * Time    : 9:55 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.services;

import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto.TLDTO;

public interface TLService {
    TLDTO saveTL(TLDTO tldto);
    void updateTL(String nic,TLDTO tldto);
    void deleteTL(String nic);
    TLDTO getTLByNic(String nic);

}
