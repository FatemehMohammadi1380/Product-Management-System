package edu.webclass.restapi.Product.Management.System.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountryDto {
    public String iso2;
    public String iso3;
    public String countryName;
    public ArrayList<String> cities;


}
