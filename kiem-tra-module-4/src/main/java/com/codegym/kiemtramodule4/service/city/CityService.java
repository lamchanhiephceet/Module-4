package com.codegym.kiemtramodule4.service.city;

import com.codegym.kiemtramodule4.model.City;
import com.codegym.kiemtramodule4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CityService extends IGeneralService<City> {

    Page<City> findAll(Pageable pageable);

    Optional<City> findById(Integer id);

    void save(City object);

    void delete(Integer id);
}
