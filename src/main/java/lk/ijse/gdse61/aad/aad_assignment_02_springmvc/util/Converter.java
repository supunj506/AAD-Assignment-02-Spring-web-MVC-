/*
 * Author  : supun@mj
 * Project : assignment02
 * Date    : 9/20/2023
 * Time    : 6:17 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.util;

import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto.ProjectDTO;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.dto.TLDTO;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.entity.ProjectEntity;
import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.entity.TLEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    private final ModelMapper modelMapper;

    Converter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProjectDTO getProjectDTO(ProjectEntity projectEntity){return modelMapper.map(projectEntity,ProjectDTO.class);}
    public  ProjectEntity getProjectEntity(ProjectDTO projectDTO){return modelMapper.map(projectDTO,ProjectEntity.class);}

    public TLEntity getTLEntity(TLDTO tldto){
        return modelMapper.map(tldto, TLEntity.class);
    }
    public TLDTO getTLDTO(TLEntity tlEntity){return modelMapper.map(tlEntity, TLDTO.class);}

}
