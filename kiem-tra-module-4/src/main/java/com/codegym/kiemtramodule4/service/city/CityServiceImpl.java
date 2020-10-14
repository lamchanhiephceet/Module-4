package com.codegym.kiemtramodule4.service.city;

import com.codegym.kiemtramodule4.model.City;
import com.codegym.kiemtramodule4.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;


    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public Optional<City> findById(Integer id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City object) {
        cityRepository.save(object);
    }

    @Override
    public void delete(Integer id) {
        cityRepository.deleteById(id);
    }
}
