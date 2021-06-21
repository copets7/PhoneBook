package by.itstep.phonebook.service;

import by.itstep.phonebook.entity.Group;

import java.util.Set;

public interface GroupService {

    Set<Group> insertGroups(Set<Group> groups);
}
