package com.techsonnet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataSource {
    String userName;
    String password;
    String url;
    String driverName;
}
