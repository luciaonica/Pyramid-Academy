package org.exampleConstructorInjection;

public class Address {
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Address(String city, String state, String country, String zipCode) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
