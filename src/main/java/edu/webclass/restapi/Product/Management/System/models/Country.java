package edu.webclass.restapi.Product.Management.System.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Country {
    private Long id;
    private String country;
    private String iso2;
    private String iso3;
    private List<String> cities;
}
