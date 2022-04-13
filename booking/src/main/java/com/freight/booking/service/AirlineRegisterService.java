package com.freight.booking.service;

import com.freight.booking.entity.AirlineRegisterEntity;
import com.freight.booking.exception.AirlineRegisterException;
import com.freight.booking.repo.AirlineRegisterRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AirlineRegisterService {

    private AirlineRegisterRepo airlineRegisterRepo;

    @Transactional
    public AirlineRegisterEntity saveAirline(AirlineRegisterEntity airlineRegisterEntity) {
        return airlineRegisterRepo.save(airlineRegisterEntity);
    }

    @Transactional
    public AirlineRegisterEntity updateAirlineById(AirlineRegisterEntity airlineRegisterEntity)
    {
        return airlineRegisterRepo.save(airlineRegisterEntity);
    }

    public Optional<AirlineRegisterEntity> getAirlineById(long id)
    {
        return  airlineRegisterRepo.findById(id);
    }

    public List<AirlineRegisterEntity> getAllAirline()
    {
        return airlineRegisterRepo.findAll();
    }

    @Transactional
    public boolean deleteAirlineById(long id)
    {
        try{
            airlineRegisterRepo.deleteById(id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
         return false;
    }

}
