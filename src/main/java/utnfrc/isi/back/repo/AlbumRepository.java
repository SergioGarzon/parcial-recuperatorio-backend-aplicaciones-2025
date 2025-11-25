package utnfrc.isi.back.repo;

import utnfrc.isi.back.domain.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class AlbumRepository {
    private final EntityManager entityManager;

    public AlbumRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Album save(Album album) {
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        return album;
    }

    public Optional<Album> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Album.class, id));
    }

    public List<Album> findAll() {
        TypedQuery<Album> query = entityManager.createQuery("SELECT a FROM Album a", Album.class);
        return query.getResultList();
    }

    public List<Album> findByTitleContaining(String text) {
        TypedQuery<Album> query = entityManager.createQuery(
            "SELECT a FROM Album a WHERE LOWER(a.title) LIKE LOWER(:text)", Album.class);
        query.setParameter("text", "%" + text + "%");
        return query.getResultList();
    }

    public void update(Album album) {
        entityManager.getTransaction().begin();
        entityManager.merge(album);
        entityManager.getTransaction().commit();
    }

    public void delete(Album album) {
        entityManager.getTransaction().begin();
        entityManager.remove(album);
        entityManager.getTransaction().commit();
    }
}
