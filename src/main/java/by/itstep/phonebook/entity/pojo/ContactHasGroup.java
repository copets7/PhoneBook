package by.itstep.phonebook.entity.pojo;

import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.entity.Group;
import com.opencsv.bean.CsvBindByName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactHasGroup {

    @CsvBindByName(column = "id")
    private Integer id;
    @CsvBindByName(column = "contact_id")
    private Integer contactId;
    @CsvBindByName(column = "group_id")
    private Integer groupId;

    public ContactHasGroup(Integer id, Integer contactId, Integer groupId) {
        this.id = id;
        this.contactId = contactId;
        this.groupId = groupId;
    }

    public ContactHasGroup() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public static List<ContactHasGroup> parse(Contact contact, Integer id) {
        List<ContactHasGroup> contactHasGroups = new ArrayList<>();
        Integer contactId = contact.getId();
        for (Group group: contact.getGroups()){
            contactHasGroups.add(new ContactHasGroup(id, contactId, group.getId()));
            id++;
        }
        return contactHasGroups;
    }
}
