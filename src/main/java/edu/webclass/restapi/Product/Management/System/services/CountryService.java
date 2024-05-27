package edu.webclass.restapi.Product.Management.System.services;

import edu.webclass.restapi.Product.Management.System.models.Country;
import edu.webclass.restapi.Product.Management.System.models.response.CountryResponse;
import edu.webclass.restapi.Product.Management.System.models.response.ExternalCountriesResponse;
import edu.webclass.restapi.Product.Management.System.models.response.GetAllCountriesResponse;
import edu.webclass.restapi.Product.Management.System.services.external_service.ExternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final ExternalService externalService;
    private final RestTemplate restTemplate;

    public ResponseEntity<GetAllCountriesResponse> getAllCountries() {
        Optional<ExternalCountriesResponse> response = externalService.getAllCountries();
        if (response.isEmpty()) return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        ExternalCountriesResponse countries = response.get();
        GetAllCountriesResponse getAllCountriesResponse = GetAllCountriesResponse
                .builder()
                .count(countries.getData().size())
                .countries(countries.getData().stream()
                        .map(country -> CountryResponse.builder()
                                .name(country.getCountry()).build()).toList()).build();
        return new ResponseEntity<>(getAllCountriesResponse, HttpStatus.OK);
    }
}
