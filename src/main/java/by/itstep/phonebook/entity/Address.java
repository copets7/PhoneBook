package by.itstep.phonebook.entity;

public class Address {

    private Integer id;
    private String city;
    private String county;
    private String street;
    private String building;

    public Address(String city, String county, String street, String building) {
        this.city = city;
        this.county = county;
        this.street = street;
        this.building = building;
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Integer getId() {
        return id;
    }
}
