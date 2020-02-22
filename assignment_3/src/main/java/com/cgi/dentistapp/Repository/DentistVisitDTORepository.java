package com.cgi.dentistapp.Repository;

import com.cgi.dentistapp.dto.DentistVisit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DentistVisitDTORepository extends JpaRepository<DentistVisit, Long> {

//    @Query("select c from 'DENTIST_VISIT' c where c.id  = ?1")
//    Optional<DentistVisitDTO> findById(Long id);

    @Query(value = "select c from DENTIST_VISIT c where c.dentistName  = ?1 ", nativeQuery = true)
    List<DentistVisit> findByDentistName(String name);
}
