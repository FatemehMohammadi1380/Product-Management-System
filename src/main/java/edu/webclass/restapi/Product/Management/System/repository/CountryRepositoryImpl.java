//package edu.webclass.restapi.Product.Management.System.repository.impl;
//
//import edu.webclass.restapi.Product.Management.System.models.Country;
//import edu.webclass.restapi.Product.Management.System.repository.CountryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//import java.util.Optional;
//
//public class CountryRepositoryImpl implements CountryRepository {
//
//    private final EntityManager entityManager;
//
//    @Autowired
//    public CustomRepository(EntityManagerFactory entityManagerFactory) {
//        this.entityManager = entityManagerFactory.createEntityManager();
//    }
//    @Override
//    public List<Country> findAll() {
//        return entityManager.createQuery("SELECT c FROM Country c", Country.class).getResultList();
//    }
//
//    @Override
//    public Optional<Country> findById(Long id) {
//        return Optional.ofNullable(entityManager.find(Country.class, id));
//    }
//
//    @Override
//    public Country save(Country country) {
//        if (country.getId() == null) {
//            entityManager.persist(country);
//            return country;
//        } else {
//            return entityManager.merge(country);
//        }
//    }
//
//    @Override
//    public void delete(Country country) {
//        entityManager.remove(entityManager.contains(country) ? country : entityManager.merge(country));
//    }
//
//    @Override
//    public Optional<Country> findByName(String name) {
//        List<Country> countries = entityManager.createQuery("SELECT c FROM Country c WHERE c.name = :name", Country.class)
//                .setParameter("name", name)
//                .getResultList();
//        if (countries.isEmpty()) {
//            return Optional.empty();
//        } else {
//            return Optional.of(countries.get(0));
//        }
//    }
//
//    @Override
//    public Optional<Country> findByIso2(String iso2) {
//        List<Country> countries = entityManager.createQuery("SELECT c FROM Country c WHERE c.iso2 = :iso2", Country.class)
//                .setParameter("iso2", iso2)
//                .getResultList();
//        if (countries.isEmpty()) {
//            return Optional.empty();
//        } else {
//            return Optional.of(countries.get(0));
//        }
//    }
//
//    @Override
//    public Optional<Country> findByIso3(String iso3) {
//        List<Country> countries = entityManager```java
//        entityManager.createQuery("SELECT c FROM Country c WHERE c.iso3 = :iso3", Country.class)
//                .setParameter("iso3", iso3)
//                .getResultList();
//        if (countries.isEmpty()) {
//            return Optional.empty();
//        } else {
//            return Optional.of(countries.get(0));
//        }
//    }
//}
