package com.drbotro.webrs.controller.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drbotro.coreservice.doctor.DoctorService;
import com.drbotro.coreserviceapi.doctor.Doctor;
import com.drbotro.webapi.versions.v1.ResourceVersion;

@RestController
@RequestMapping(ResourceVersion.V1)
public class DoctorController{

    @Autowired
    private DoctorService doctorService;

    /*
    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }
    */

    @GetMapping(path = "/doctors", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Doctor>> getDoctors(){
        return new ResponseEntity<>(doctorService.getDoctors(), HttpStatus.OK);
    }

}
