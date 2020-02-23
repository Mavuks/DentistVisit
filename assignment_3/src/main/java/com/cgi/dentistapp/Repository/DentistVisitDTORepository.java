package com.cgi.dentistapp.Repository;

import com.cgi.dentistapp.dto.DentistVisit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DentistVisitDTORepository extends JpaRepository<DentistVisit, Long> {

}
