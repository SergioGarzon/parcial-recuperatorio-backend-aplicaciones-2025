package utnfrc.isi.back.repo;


import utnfrc.isi.back.domain.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ArtistRepository {
    
    private final EntityManager entityManager;

    public ArtistRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Guardar un artista
    public Artist save(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        return artist;
    }

    // Buscar un artista por ID
    public Optional<Artist> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Artist.class, id));
    }

    // Buscar todos los artistas
    public List<Artist> findAll() {
        TypedQuery<Artist> query = entityManager.createQuery("SELECT a FROM Artist a", Artist.class);
        return query.getResultList();
    }

    // Buscar artistas cuyo nombre contenga un texto
    public List<Artist> findByNameContaining(String text) {
        TypedQuery<Artist> query = entityManager.createQuery(
            "SELECT a FROM Artist a WHERE LOWER(a.name) LIKE LOWER(:text)", Artist.class);
        query.setParameter("text", "%" + text + "%");
        return query.getResultList();
    }

    // Actualizar un artista
    public void update(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.merge(artist);
        entityManager.getTransaction().commit();
    }

    // Eliminar un artista
    public void delete(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.remove(artist);
        entityManager.getTransaction().commit();
    }
}