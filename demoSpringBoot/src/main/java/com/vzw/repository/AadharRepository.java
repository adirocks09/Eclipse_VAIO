package com.vzw.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vzw.entity.Aadhar;

@Repository
public interface AadharRepository extends JpaRepository<Aadhar,Integer> {

}
