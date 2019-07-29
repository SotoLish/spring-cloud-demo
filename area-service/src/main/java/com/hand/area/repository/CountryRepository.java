package com.hand.area.repository;

import com.hand.area.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Country类持久层
 *
 * @author liuqixin
 * @date 2019/7/26 09:22
 */
public interface CountryRepository extends JpaRepository<Country, Long> {

}
