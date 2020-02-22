package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.Dentist;
import com.cgi.dentistapp.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
public class DentistController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistService dentistService;


    @CrossOrigin
    @GetMapping("/dentists")
    public List<Dentist> getDentists(){

        return dentistService.getDentists();

    }
//    @CrossOrigin
//    @RequestMapping(value = "appointments/{id}", method = RequestMethod.GET)
//    public Optional<DentistVisitDTO> getVisit(@PathVariable("id") Long id) {
//        System.out.println(id);
//        return dentistVisitService.getVisit(id);
//    }

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/dentist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postDentist(@Valid @RequestBody Dentist dentist) {
        dentistService.addDentist(dentist);

    }

//
//    @CrossOrigin
//    @DeleteMapping("appointments/{id}")
//    public void deleteDentistVisit(@PathVariable("id") Long id){
//        dentistVisitService.removeDentistVisit(id);
//
//
//    }
//    @CrossOrigin
//    @Transactional
//    @RequestMapping(value = "appointments/{id}", method = RequestMethod.PUT,  consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void updateAppointment(@PathVariable Long id, @RequestBody DentistVisitDTO dentistVisitDTO){
//            dentistVisitService.updateById(id, dentistVisitDTO);
//
//    }


}
