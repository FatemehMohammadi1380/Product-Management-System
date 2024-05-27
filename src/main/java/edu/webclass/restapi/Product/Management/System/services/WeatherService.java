package edu.webclass.restapi.Product.Management.System.services;

import edu.webclass.restapi.Product.Management.System.models.Weather;
import edu.webclass.restapi.Product.Management.System.models.response.*;
import edu.webclass.restapi.Product.Management.System.services.external_service.ExternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private final ExternalService externalService;

    private static final String WEATHER_API_URL = "http://api.weatherapi.com/v1/current.json?key=YOUR_API_KEY&q=";


    public Weather getWeatherForCountry(String countryName) {
        String url = WEATHER_API_URL + countryName;
        return restTemplate.getForObject(url, Weather.class);
    }

    public ResponseEntity<GetCountryWeatherResponse> getCountryWeather(String countryName) {
        Optional<ExternalWeatherResponse> response = externalService.getWeatherInfo(countryName);

        System.out.println(response);

        if (response.isEmpty()) return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);

        Optional<List<ExternalCountryInfoResponse>> country_response = externalService.getCountryInfo(countryName);
        List<ExternalCountryInfoResponse> countryInfo = country_response.get();


        ExternalWeatherResponse weather = response.get();
        GetCountryWeatherResponse getWeatherResponse = GetCountryWeatherResponse
                .builder()
                .country_name(countryName)
                .temp(weather.getTemp())
                .wind_degrees(weather.getWind_degrees())
                .wind_speed(weather.getWind_speed())
                .capital(countryInfo.get(0).getCapital())
                .humidity(weather.getHumidity())
        .build();
        return new ResponseEntity<>(getWeatherResponse, HttpStatus.OK);
    }
}
