package by.itstep.phonebook.entity;

import java.util.Set;

public class Contact {

    private Integer id;
    private String firsName;
    private String lastName;
    private Set<String> phones;
    private Address address;
    private Set<Group> groups;

    public Contact(String firsName, String lastName, Set<String> phones, Address addresse, Set<Group> groups) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.phones = phones;
        this.address = addresse;
        this.groups = groups;
    }

    public Contact() {
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public Address getAddresse() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
