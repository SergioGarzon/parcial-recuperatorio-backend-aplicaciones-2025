package utnfrc.isi.back.repo;

import utnfrc.isi.back.domain.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class InvoiceRepository {
    private final EntityManager entityManager;

    public InvoiceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Invoice save(Invoice invoice) {
        entityManager.getTransaction().begin();
        entityManager.persist(invoice);
        entityManager.getTransaction().commit();
        return invoice;
    }

    public Optional<Invoice> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Invoice.class, id));
    }

    public List<Invoice> findAll() {
        TypedQuery<Invoice> query = entityManager.createQuery("SELECT i FROM Invoice i", Invoice.class);
        return query.getResultList();
    }

    public List<Invoice> findByTotalGreaterThan(Float total) {
        TypedQuery<Invoice> query = entityManager.createQuery(
            "SELECT i FROM Invoice i WHERE i.total > :total", Invoice.class);
        query.setParameter("total", total);
        return query.getResultList();
    }

    public void update(Invoice invoice) {
        entityManager.getTransaction().begin();
        entityManager.merge(invoice);
        entityManager.getTransaction().commit();
    }

    public void delete(Invoice invoice) {
        entityManager.getTransaction().begin();
        entityManager.remove(invoice);
        entityManager.getTransaction().commit();
    }
}