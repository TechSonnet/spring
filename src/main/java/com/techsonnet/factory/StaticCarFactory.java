package com.techsonnet.factory;

import com.techsonnet.entity.Car;

import java.util.HashMap;
import java.util.Map;

public class StaticCarFactory {
    private static  Map<Integer, Car> carMap;

    static {
        carMap = new HashMap<Integer, Car>();
        carMap.put(1,new Car(1L,"aodi"));
        carMap.put(2,new Car(2L,"aotuo"));
    }

    public static Car getCar(Integer num){
        return carMap.get(num);
    }
}
