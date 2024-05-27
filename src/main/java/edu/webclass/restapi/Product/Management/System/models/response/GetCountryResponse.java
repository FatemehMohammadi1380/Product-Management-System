package edu.webclass.restapi.Product.Management.System.models.response;

import edu.webclass.restapi.Product.Management.System.models.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetCountryResponse {

    private String name;
    private String capital;
    private String iso2;
    private long population;
    private double pop_growth;
    private Currency currency;

}
