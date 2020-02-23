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


    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/dentist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postDentist(@Valid @RequestBody Dentist dentist) {
        dentistService.addDentist(dentist);

    }



}
