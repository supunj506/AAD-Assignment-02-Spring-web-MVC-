/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/20/2023
 * Time    : 9:38 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.config;

import lk.ijse.gdse61.aad.aad_assignment_02_springmvc.WebAppInitializer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ComponentScan(basePackageClasses = WebAppInitializer.class)
public class WebAppConfig {
    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();}
}
