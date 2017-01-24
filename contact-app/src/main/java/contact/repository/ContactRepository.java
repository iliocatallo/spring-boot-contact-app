package contact.repository;

import contact.domain.Contact;
import java.util.List;

public interface ContactRepository {
    public List<Contact> findAll();
    public void save(Contact contact);
}
