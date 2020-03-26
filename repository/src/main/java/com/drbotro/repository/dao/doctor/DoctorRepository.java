package com.drbotro.repository.dao.doctor;


import org.springframework.data.jpa.repository.JpaRepository;

import com.drbotro.coreserviceapi.doctor.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
}

