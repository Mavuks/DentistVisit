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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class DentistVisitService {

    @Autowired
    DentistVisitDTORepository dentistVisitDTORepository;

    @PersistenceContext
    private EntityManager em;

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
        System.out.println(dentistVisitDTORepository.findById(id));
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

    public boolean findByDentistName(String name, Date time){
        TypedQuery<DentistVisit> query = em.createQuery("select p from DentistVisit p where p.dentistName = :name and p.visitTime = :time", DentistVisit.class);

        query.setParameter("name", name);
        query.setParameter("time", time);

        DentistVisit dentistVisit  = query.getSingleResult();
        if(dentistVisit != null){
            return false;
        }else{
            return true;
        }

    }
}
