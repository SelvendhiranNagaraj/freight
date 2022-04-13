package com.freight.booking.repo;

import com.freight.booking.entity.CompanyRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRegisterRepo extends JpaRepository<CompanyRegisterEntity,Long> {
}
