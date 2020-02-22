package com.cgi.dentistapp.service;

import com.cgi.dentistapp.Repository.DentistRepository;
import com.cgi.dentistapp.Repository.VisitTimeRepository;
import com.cgi.dentistapp.dto.Dentist;
import com.cgi.dentistapp.dto.VisitTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service

public class VisitTimeService {

    @Autowired
    VisitTimeRepository visitTimeRepository;



    @Transactional
    public void addVisitTime(@Valid VisitTime visitTime) {
        visitTimeRepository.save(visitTime);
    }


    public List<VisitTime> getVisitsTimes() {

        return visitTimeRepository.findAll();

    }


}
