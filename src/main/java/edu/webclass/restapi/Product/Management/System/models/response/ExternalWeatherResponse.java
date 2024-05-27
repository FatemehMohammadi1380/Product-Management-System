package edu.webclass.restapi.Product.Management.System.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExternalWeatherResponse {

    private double wind_speed;
    private int wind_degrees;
    private int temp;
    private int humidity;
    private long sunset;
    private int min_temp;
    private int cloud_pct;
    private int feels_like;
    private long sunrise;
    private int max_temp;

}
