package edu.webclass.restapi.Product.Management.System.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetAllCountriesResponse {
    private List<CountryResponse> countries;
    private Integer count;
}
