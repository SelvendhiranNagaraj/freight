package com.freight.booking.service;

import com.freight.booking.entity.CompanyRegisterEntity;
import com.freight.booking.repo.CompanyRegisterRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class CompanyRegisterService {

    private CompanyRegisterRepo companyRegisterRepo;

    @Transactional
    public CompanyRegisterEntity saveCompany(CompanyRegisterEntity companyRequest){
        return companyRegisterRepo.save(companyRequest);
    }
}
