package contact.application;

import contact.domain.Contact;
import contact.repository.ContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    @Autowired
    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Contact contact) {
        repository.save(contact);
    }
}
