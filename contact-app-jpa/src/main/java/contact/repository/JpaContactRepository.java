package contact.repository;

import contact.domain.Contact;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class JpaContactRepository implements ContactRepository {

    @PersistenceContext
    private EntityManager em;

    public JpaContactRepository() {}
    
    @Override
    public List<Contact> findAll() {
        TypedQuery<Contact> query = em.createQuery("SELECT c FROM Contact c", Contact.class);
        return query.getResultList();
    }

    @Override
    public void save(Contact contact) {
        em.persist(contact);
    }
}
