package contact.repository;

import contact.domain.Contact;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class InMemoryContactRepository implements ContactRepository {

    private final Map<Long, Contact> contacts;

    public InMemoryContactRepository() {
        this.contacts = new HashMap<>();
    }
    
    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(contacts.values());
    }

    @Override
    public void save(Contact contact) {
        contacts.put(contact.getId(), contact);
    }
}
