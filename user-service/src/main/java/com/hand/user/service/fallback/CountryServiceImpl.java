package com.hand.user.service.fallback;

import com.hand.area.entity.Country;
import com.hand.user.service.CountryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author liuqixin
 * @date 2019/7/25 11:02
 */
@Component
@Qualifier("CountryService")
public class CountryServiceImpl implements CountryService {

    private static final Country ERROR = new Country().setCountryName("ERROR");

    @Override
    public Country queryCountry(long countryId) {
        return ERROR;
    }
}
