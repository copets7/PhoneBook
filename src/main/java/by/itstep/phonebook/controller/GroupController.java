package by.itstep.phonebook.controller;

public interface GroupController {

    void createGroup(String name);
    void addGroupMemberByPhone(String phone);
    void removeGroupMemberByPhone(String phone);
    void addGroupMemberById(Integer id);
    void removeGroupMemberById(Integer id);
    void deleteGroup(String name);
    void deleteGroup(Integer id);
}
