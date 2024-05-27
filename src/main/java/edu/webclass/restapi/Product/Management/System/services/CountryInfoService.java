package edu.webclass.restapi.Product.Management.System.services;

import edu.webclass.restapi.Product.Management.System.models.response.*;
import edu.webclass.restapi.Product.Management.System.services.external_service.ExternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryInfoService {

    private final ExternalService externalService;
    private final RestTemplate restTemplate;

    public ResponseEntity<GetCountryResponse> getCountry(String name) {

        Optional<List<ExternalCountryInfoResponse>> response = externalService.getCountryInfo(name);
        if (response.isEmpty()) return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);

        List<ExternalCountryInfoResponse> countryInfo = response.get();
        GetCountryResponse getCountryResponse = GetCountryResponse
                .builder()
                .name(countryInfo.get(0).getName())
                .iso2(countryInfo.get(0).getIso2())
                .population(countryInfo.get(0).getPopulation())
                .pop_growth(countryInfo.get(0).getPop_growth())
                .currency(countryInfo.get(0).getCurrency())
                .capital(countryInfo.get(0).getCapital())
                .build();
        return new ResponseEntity<>(getCountryResponse, HttpStatus.OK);
    }


}
