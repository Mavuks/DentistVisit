package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
public class Dentist extends BaseEntity {

    String dentistName;
}
