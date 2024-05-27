package edu.webclass.restapi.Product.Management.System.models.response;

import edu.webclass.restapi.Product.Management.System.models.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExternalCountriesResponse {
    private Boolean error;
    private String msg;
    private List<Country> data;
}
