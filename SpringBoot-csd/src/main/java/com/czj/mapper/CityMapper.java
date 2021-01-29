package com.czj.mapper;

import com.czj.pojo.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {

    List<City> queryAllCity();
}
