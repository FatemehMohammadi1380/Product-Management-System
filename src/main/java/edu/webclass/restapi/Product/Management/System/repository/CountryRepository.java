package edu.webclass.restapi.Product.Management.System.repository;

import edu.webclass.restapi.Product.Management.System.models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Country save(Country country);
    void delete(Country country);
    Optional<Country> findByName(String name);
    Optional<Country> findByIso2(String iso2);
    Optional<Country> findByIso3(String iso3);
}
