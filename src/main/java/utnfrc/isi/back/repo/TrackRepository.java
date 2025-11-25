package utnfrc.isi.back.repo;

import utnfrc.isi.back.domain.Track;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class TrackRepository {
    private final EntityManager entityManager;

    public TrackRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Track save(Track track) {
        entityManager.getTransaction().begin();
        entityManager.persist(track);
        entityManager.getTransaction().commit();
        return track;
    }

    public Optional<Track> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Track.class, id));
    }

    public List<Track> findAll() {
        TypedQuery<Track> query = entityManager.createQuery("SELECT t FROM Track t", Track.class);
        return query.getResultList();
    }

    public List<Track> findByNameContaining(String text) {
        TypedQuery<Track> query = entityManager.createQuery(
            "SELECT t FROM Track t WHERE LOWER(t.name) LIKE LOWER(:text)", Track.class);
        query.setParameter("text", "%" + text + "%");
        return query.getResultList();
    }

    public void update(Track track) {
        entityManager.getTransaction().begin();
        entityManager.merge(track);
        entityManager.getTransaction().commit();
    }

    public void delete(Track track) {
        entityManager.getTransaction().begin();
        entityManager.remove(track);
        entityManager.getTransaction().commit();
    }
}