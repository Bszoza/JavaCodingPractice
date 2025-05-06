package phonebookoptional;

import java.util.*;

public class ContactManager {
    private static Set<Contact> contacts = new HashSet<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public static Optional <Contact> findByEmail(String email) {
        for (Contact contact : contacts) {
            if (email.equals(contact.getEmail()))
                return Optional.of(contact);
        } return  Optional.empty();
    }

    public List<Contact> findByLastName(String textFragment) {
        if (textFragment == null)
            throw new NullPointerException("search text cannot be null");
        List<Contact> foundContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getLastName().contains(textFragment))
                foundContacts.add(contact);
        }
        return foundContacts;
    }
}