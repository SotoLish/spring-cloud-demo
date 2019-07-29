package com.hand.area.service;

import com.hand.area.entity.Country;
import com.hand.area.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuqixin
 * @date 2019/7/26 09:59
 */
@Component
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getList() {
        return countryRepository.findAll();
    }

    @Override
    public Country queryById(Long aLong) {
        return countryRepository.getOne(aLong);
    }

    @Override
    public Country create(Country object) {
        return countryRepository.save(object);
    }

    @Override
    public Country update(Country object) {
        return countryRepository.save(object);
    }

    @Override
    public void delete(Long aLong) {
        countryRepository.deleteById(aLong);
    }
}
