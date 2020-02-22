package com.cgi.dentistapp.Repository;

import com.cgi.dentistapp.dto.Dentist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {


}