package com.drbotro.coreservice.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drbotro.coreserviceapi.doctor.Doctor;
import com.drbotro.repository.dao.doctor.DoctorRepository;

@Service
public class DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    /*
    @PostConstruct
    public void initDoctor(){
        doctorRepository
                .saveAll(Stream.of(new Doctor(101, "nameuno", "emailuno"), new Doctor(102, "namedos", "emaildos"))
                        .collect(Collectors.toList()));
    }
    */

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

}
