/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/20/2023
 * Time    : 10:31 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.api;

import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto.TLDTO;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.services.TLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tl")
public class TLController {
    @Autowired
    TLService tlService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    TLDTO saveTL(@RequestPart String nic,
                 @RequestPart String name,
                 @RequestPart String email,
                 @RequestPart String contact){
        if(nic==null){
            throw new RuntimeException("Invalid Id");
        } else if (name==null) {
            throw new RuntimeException("Invalid name");
        } else if (email==null) {
            throw new RuntimeException("Invalid email");
        }else if (contact==null){
            throw new RuntimeException("Invalid contact");
        }

        return tlService.saveTL(new TLDTO(nic,name,email,contact));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping( "{nic}")
    void updateTL(@PathVariable String nic,
                  @RequestPart String name,
                  @RequestPart String email,
                  @RequestPart String contact){
        if(nic==null){
            throw new RuntimeException("Invalid nic");
        } else if (name==null) {
            throw new RuntimeException("Invalid name");
        } else if (email==null) {
            throw new RuntimeException("Invalid email");
        }else if (contact==null){
            throw new RuntimeException("Invalid contact");
        }

        tlService.updateTL(nic,new TLDTO(name,email,contact));

        System.out.println("running patch");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{nic}")
    void deleteTL(@PathVariable String nic){tlService.deleteTL(nic);}



    @GetMapping(value = "{nic}",produces = MediaType.APPLICATION_JSON_VALUE)
    TLDTO getSelectedTL(@PathVariable String nic){
        if(nic==null) throw new RuntimeException("NIC is invalid");
        return tlService.getTLByNic(nic);
    }



}
