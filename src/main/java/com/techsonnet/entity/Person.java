package com.techsonnet.entity;

import com.techsonnet.factory.InstanceCarFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Person {
    private Integer id;
    private String name;
    private Car car;
}
