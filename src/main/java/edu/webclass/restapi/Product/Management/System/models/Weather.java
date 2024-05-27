package edu.webclass.restapi.Product.Management.System.models;

public class Weather {
    private String countryName;
    private String capital;
    private double windSpeed;
    private int windDegrees;
    private double temperature;
    private int humidity;

    // Constructors
    public Weather() {}

    public Weather(String countryName, String capital, double windSpeed, int windDegrees, double temperature, int humidity) {
        this.countryName = countryName;
        this.capital = capital;
        this.windSpeed = windSpeed;
        this.windDegrees = windDegrees;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    // Getters and Setters
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDegrees() {
        return windDegrees;
    }

    public void setWindDegrees(int windDegrees) {
        this.windDegrees = windDegrees;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}

