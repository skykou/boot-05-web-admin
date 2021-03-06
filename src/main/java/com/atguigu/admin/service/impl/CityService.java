package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.mapper.CityMapper;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangtao
 * @date 2022/5/26 - 21:05
 */
@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    private Counter counter;

    public CityService(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("cityService.saveCity.count");
        System.out.println(counter);
        System.out.println(counter);
        System.out.println(counter);
        System.out.println(counter+"master tset");
        System.out.println(counter+"hot-fix test");
        System.out.println(counter+"push test!");
        System.out.println(counter+"pull test!");
    }

    public City getById(Long id){
        return cityMapper.getById(id);
    }

    public void saveCity(City city) {
        counter.increment();
        cityMapper.insert(city);
    }
}
