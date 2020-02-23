package com.cgi.dentistapp.service;

import com.cgi.dentistapp.Repository.DentistVisitDTORepository;
import com.cgi.dentistapp.dto.DentistVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service

public class DentistVisitService {

    @Autowired
    DentistVisitDTORepository dentistVisitDTORepository;

    @Transactional
    public void addVisit(@Valid DentistVisit dentistVisit) {
        dentistVisitDTORepository.save(dentistVisit);
    }



    public List<DentistVisit> getVisits() {

        return dentistVisitDTORepository.findAll();

    }

    public void removeDentistVisit(Long id){
        dentistVisitDTORepository.deleteById(id);

    }

    public Optional<DentistVisit> getVisit(Long id){
        return  dentistVisitDTORepository.findById(id);
    }

    public void updateById(Long id, DentistVisit dentistVisitDTO){
        Optional<DentistVisit> visitData = dentistVisitDTORepository.findById(id);
        if(visitData.isPresent()) {
            DentistVisit newVisit = visitData.get();
            newVisit.setDentistName(dentistVisitDTO.getDentistName());
            newVisit.setVisitTime(dentistVisitDTO.getVisitTime());
        }
    }

    public boolean findByDentistName(String name, Date time) throws ParseException {
        List<DentistVisit> dentistVisits = getVisits();
        DateFormat df = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        Date parsedDate = df.parse(String.valueOf(time));
        SimpleDateFormat print = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        String result = print.format(parsedDate);
        for (DentistVisit dentistVisit : dentistVisits) {

            String dentistTime = print.format(dentistVisit.getVisitTime());
            if (dentistTime.equals(result) && dentistVisit.getDentistName().equals(name)) {
                return false;
            }
        }

        return true;

    }
}
