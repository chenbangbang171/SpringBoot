package com.czj.pojo;

import lombok.Data;

import java.util.List;

@Data
public class City {
    private int cityId;
    private String cityName;
    private List<City> cities;
}
