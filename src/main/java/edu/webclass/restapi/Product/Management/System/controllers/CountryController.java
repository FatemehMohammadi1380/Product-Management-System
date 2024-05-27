package edu.webclass.restapi.Product.Management.System.controllers;

import edu.webclass.restapi.Product.Management.System.models.Country;
import edu.webclass.restapi.Product.Management.System.models.response.GetAllCountriesResponse;
import edu.webclass.restapi.Product.Management.System.models.response.GetCountryResponse;
import edu.webclass.restapi.Product.Management.System.models.response.GetCountryWeatherResponse;
import edu.webclass.restapi.Product.Management.System.services.CountryInfoService;
import edu.webclass.restapi.Product.Management.System.services.CountryService;
import edu.webclass.restapi.Product.Management.System.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;
    private final CountryInfoService countryInfoService;
    private final WeatherService weatherService;

    @GetMapping
    public ResponseEntity<GetAllCountriesResponse> getCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{countryName}")
    public ResponseEntity<GetCountryResponse> getCountryInfo(@PathVariable(name = "countryName") String name) {
        return countryInfoService.getCountry(name);
    }


    @GetMapping("/{name}/weather")
    public ResponseEntity<GetCountryWeatherResponse> getCountryWeather(@PathVariable(name = "name") String name) {
        return weatherService.getCountryWeather(name);
    }
}


