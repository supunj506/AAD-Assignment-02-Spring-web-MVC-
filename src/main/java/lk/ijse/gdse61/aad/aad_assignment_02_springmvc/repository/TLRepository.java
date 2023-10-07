/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/20/2023
 * Time    : 7:00 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.repository;

import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto.TLDTO;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.entity.TLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TLRepository extends JpaRepository<TLEntity,String> {
    TLEntity findTLEntityByNic(String id);
}
