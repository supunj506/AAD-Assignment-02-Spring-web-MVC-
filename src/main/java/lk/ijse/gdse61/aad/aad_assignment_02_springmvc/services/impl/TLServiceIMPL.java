/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/20/2023
 * Time    : 9:56 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.services.impl;

import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto.TLDTO;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.entity.TLEntity;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.repository.TLRepository;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.services.TLService;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TLServiceIMPL implements TLService {

    @Autowired
    TLRepository tlRepository;

    @Autowired
    Converter converter;

    @Override
    public TLDTO saveTL(TLDTO tldto) {
        TLEntity tlEntity = converter.getTLEntity(tldto);
        tlRepository.save(tlEntity);
        return tldto;
    }

    @Override
    public void updateTL(String nic, TLDTO tldto) {
        Optional<TLEntity> tempTL = tlRepository.findById(nic);
        if(!tempTL.isPresent())throw new RuntimeException("Not Fount Tech Lead in Database");
        tempTL.get().setName(tldto.getName());
        tempTL.get().setEmail(tldto.getEmail());
        tempTL.get().setContact(tldto.getContact());

   }

    @Override
    public void deleteTL(String nic) {
        if(!tlRepository.existsById(nic)) throw new RuntimeException("Not Fount Tech Lead in Database");
        tlRepository.deleteById(nic);
    }

    @Override
    public TLDTO getTLByNic(String nic) {
        if(!tlRepository.existsById(nic)) throw new RuntimeException("Not Fount Tech Lead in Database");
        TLEntity tlEntity = tlRepository.findTLEntityByNic(nic);
//        System.out.println(tlEntity.getNic()+" "+ tlEntity.getName()+" "+ tlEntity.getEmail()+" "+tlEntity.getContact());
        return converter.getTLDTO(tlEntity);
    }
}
