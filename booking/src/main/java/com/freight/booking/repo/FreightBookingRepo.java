package com.freight.booking.repo;

import com.freight.booking.entity.FreightBookingRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreightBookingRepo extends JpaRepository<FreightBookingRequestEntity,Long> {

}
