package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisit;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService;


    @CrossOrigin
    @GetMapping("/appointments")
    public List<DentistVisit> showAppointments() {
        return dentistVisitService.getVisits();

    }

    @CrossOrigin
    @RequestMapping(value = "appointments/{id}", method = RequestMethod.GET)
    public Optional<DentistVisit> getVisit(@PathVariable("id") Long id) {
        return dentistVisitService.getVisit(id);
    }


    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus postDentistVisit(@Valid @RequestBody DentistVisit dentistVisit) throws ParseException {

        boolean post = dentistVisitService.findByDentistName(dentistVisit.getDentistName(), dentistVisit.getVisitTime());

        if (post) {
            dentistVisitService.addVisit(dentistVisit);
        } else {
            return HttpStatus.BAD_REQUEST;
        }


        return null;
    }


    @CrossOrigin
    @DeleteMapping("appointments/{id}")
    public void deleteDentistVisit(@PathVariable("id") Long id) {
        dentistVisitService.removeDentistVisit(id);


    }


    @CrossOrigin
    @Transactional
    @RequestMapping(value = "appointments/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateAppointment(@PathVariable Long id, @RequestBody DentistVisit dentistVisit) throws ParseException {

        boolean post = dentistVisitService.findByDentistName(dentistVisit.getDentistName(), dentistVisit.getVisitTime());
        if (post) {

            dentistVisitService.updateById(id, dentistVisit);
        } else {
            return HttpStatus.BAD_REQUEST;
        }


        return null;


    }


}
