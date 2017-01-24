package contact.application;

import contact.domain.Contact;
import java.util.List;

public interface ContactService {
    public List<Contact> findAll();
    public void save(Contact contact);
}
