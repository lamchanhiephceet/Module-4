package com.codegym.kiemtramodule4.service.nation;

import com.codegym.kiemtramodule4.model.Nation;
import com.codegym.kiemtramodule4.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationRepository nationRepository;

    @Override
    public Page<Nation> findAll(Pageable pageable) {
        return nationRepository.findAll(pageable);
    }

    @Override
    public Optional<Nation> findById(Integer id) {
        return nationRepository.findById(id);
    }

    @Override
    public void save(Nation object) {
        nationRepository.save(object);
    }

    @Override
    public void delete(Integer id) {
        nationRepository.deleteById(id);
    }
}
