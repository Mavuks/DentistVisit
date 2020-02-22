package com.cgi.dentistapp.service;

import com.cgi.dentistapp.Repository.DentistRepository;
import com.cgi.dentistapp.dto.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service

public class DentistService {

    @Autowired
    DentistRepository dentistRepository;



    @Transactional
    public void addDentist(@Valid Dentist dentist) {
        dentistRepository.save(dentist);
    }


    public List<Dentist> getDentists() {

        return dentistRepository.findAll();

    }


}
