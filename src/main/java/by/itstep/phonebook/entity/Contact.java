package by.itstep.phonebook.entity;

import com.opencsv.bean.CsvBindByName;

import java.util.HashSet;
import java.util.Set;

public class Contact {

    @CsvBindByName(column = "id")
    private Integer id;
    @CsvBindByName(column = "firsName")
    private String firsName;
    @CsvBindByName(column = "lastName")
    private String lastName;
    @CsvBindByName(column = "phone_set")
    private Set<String> phones;
    @CsvBindByName(column = "email")
    private String email;
    private Set<Group> groups = new HashSet<>();

    public Contact(String firsName, String lastName, Set<String> phones, String email, Set<Group> groups) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.phones = phones;
        this.email = email;
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

    public void addGroup(Group group){
        this.groups.add(group);
    }

    @Override
    public String toString(){
        return String.format("Last Name: %s  Email: %s Phones: %s Groups: %s", lastName, email, phones, groups);
    }
}
