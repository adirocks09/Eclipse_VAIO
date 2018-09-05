package com.vzw.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vzw.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike,Integer> {

}
