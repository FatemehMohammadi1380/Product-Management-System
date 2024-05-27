package edu.webclass.restapi.Product.Management.System.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetCountryWeatherResponse {

    private String country_name;
    private String capital;
    private double wind_speed;
    private int wind_degrees;
    private int temp;
    private int humidity;

}
