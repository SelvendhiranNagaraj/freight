package com.freight.booking.repo;

import com.freight.booking.entity.AirlineRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRegisterRepo extends JpaRepository<AirlineRegisterEntity,Long>{

}
