package by.itstep.phonebook.entity;

import com.opencsv.bean.CsvBindByName;

import java.util.Set;

public class Contact {

    @CsvBindByName(column = "id")
    private Integer id;
    @CsvBindByName(column = "firsName")
    private java.lang.String firsName;
    @CsvBindByName(column = "lastName")
    private java.lang.String lastName;
    @CsvBindByName(column = "phone_set")
    private Set<java.lang.String> phones;
    @CsvBindByName(column = "email")
    private String email;
    private Set<Group> groups;

    public Contact(java.lang.String firsName, java.lang.String lastName, Set<java.lang.String> phones, String addresse, Set<Group> groups) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.phones = phones;
        this.email = addresse;
        this.groups = groups;
    }

    public Contact() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.lang.String getFirsName() {
        return firsName;
    }

    public void setFirsName(java.lang.String firsName) {
        this.firsName = firsName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public Set<java.lang.String> getPhones() {
        return phones;
    }

    public void setPhones(Set<java.lang.String> phones) {
        this.phones = phones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
