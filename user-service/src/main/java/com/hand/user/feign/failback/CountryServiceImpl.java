package com.hand.user.feign.failback;

import com.hand.user.entity.Country;
import com.hand.user.feign.CountryService;
import org.springframework.stereotype.Component;

/**
 * @author liuqixin
 * @date 2019/7/25 11:02
 */
@Component
public class CountryServiceImpl implements CountryService {

    private static final Country ERROR = new Country().setCountryName("ERROR");

    @Override
    public Country queryCountry(long countryId) {
        return ERROR;
    }
}
