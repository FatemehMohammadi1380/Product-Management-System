package edu.webclass.restapi.Product.Management.System.services.external_service;


import com.fasterxml.jackson.databind.type.CollectionType;
import edu.webclass.restapi.Product.Management.System.models.response.ExternalCountriesResponse;
import edu.webclass.restapi.Product.Management.System.models.response.ExternalCountryInfoResponse;
import edu.webclass.restapi.Product.Management.System.models.response.ExternalWeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
@RequiredArgsConstructor
public class ExternalService {
    private final ObjectMapper objectMapper;

    public Optional<ExternalCountriesResponse> getAllCountries() {
        try {
            URL url = new URL("https://countriesnow.space/api/v0.1/countries");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();
            return Optional.ofNullable(objectMapper.readValue(responseStream, ExternalCountriesResponse.class));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public Optional<List<ExternalCountryInfoResponse>> getCountryInfo(String countryName) {
        try {
            URL url = new URI("https://api.api-ninjas.com/v1/country?name="+ countryName).toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setRequestProperty("X-Api-Key", "u2rOPkX9VNm926O64BBbVw==KRZ63ZsIIPYBcJZg");
            connection.setRequestProperty("accept", "*/*");

            int responseCode = connection.getResponseCode();

            InputStream responseStream = connection.getInputStream();

            ObjectMapper mapper = new ObjectMapper();
            CollectionType collectionType =
                    mapper.getTypeFactory().constructCollectionType(List.class, ExternalCountryInfoResponse.class);

            List<ExternalCountryInfoResponse> countryInfoList = mapper.readValue(responseStream,collectionType);

            return Optional.ofNullable(countryInfoList);
        } catch (IOException e) {
            System.out.println(e);
            return Optional.empty();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


    public Optional<ExternalWeatherResponse> getWeatherInfo(String countryName) {
        try {

            URL url = new URI("https://api.api-ninjas.com/v1/weather?city="+countryName).toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setRequestProperty("X-Api-Key", "u2rOPkX9VNm926O64BBbVw==KRZ63ZsIIPYBcJZg");
            connection.setRequestProperty("accept", "*/*");

            InputStream responseStream = connection.getInputStream();

            return Optional.ofNullable(objectMapper.readValue(responseStream, ExternalWeatherResponse.class));
        } catch (IOException e) {
            return Optional.empty();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }




}
