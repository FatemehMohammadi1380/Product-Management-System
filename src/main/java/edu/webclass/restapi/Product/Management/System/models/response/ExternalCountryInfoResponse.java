package edu.webclass.restapi.Product.Management.System.models.response;

import edu.webclass.restapi.Product.Management.System.models.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExternalCountryInfoResponse {

      private long gdp;
      private double sex_ratio;
      private long surface_area;
      private double life_expectancy_male;
      private double unemployment;
      private long imports;
      private int homicide_rate;
      private Currency currency;
      private String iso2;
      private double gdp_growth;
      private int employment_services;
      private double urban_population_growth;
      private double secondary_school_enrollment_female;
      private double employment_agriculture;
      private String capital;
      private double co2_emissions;
      private double forested_area;
      private long tourists;
      private long exports;
      private double life_expectancy_female;
      private double post_secondary_enrollment_female;
      private double post_secondary_enrollment_male;
      private double primary_school_enrollment_female;
      private double infant_mortality;
      private double secondary_school_enrollment_male;
      private int threatened_species;
      private long population;
      private double urban_population;
      private double employment_industry;
      private String name;
      private double pop_growth;
      private String region;
      private double pop_density;
      private double internet_users;
      private double gdp_per_capita;
      private double fertility;
      private double refugees;
      private double primary_school_enrollment_male;
}
