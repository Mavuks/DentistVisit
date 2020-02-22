package com.cgi.dentistapp.Repository;

import com.cgi.dentistapp.dto.VisitTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VisitTimeRepository extends JpaRepository<VisitTime, Long> {


}