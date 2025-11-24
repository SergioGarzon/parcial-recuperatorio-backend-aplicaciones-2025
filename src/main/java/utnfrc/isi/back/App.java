package utnfrc.isi.back;

import utnfrc.isi.back.domain.Artist;
import utnfrc.isi.back.domain.Album;
import utnfrc.isi.back.domain.Track;
import utnfrc.isi.back.infra.DbInitializer;
import utnfrc.isi.back.infra.LocalEntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.time.LocalDate;

/**
 * Proyecto para el parcial de BackEnd de Aplicaciones
 * 
 * @author Sergio Garzón - Legajo 54330
 * @version 1.0
 */
public class App {

    /**
     * Metodo principal de la aplicacion
     * @param args
     */
    public static void main(String[] args) {               

        try {
            // 1. Inicializar la base de datos y verificar
            System.out.println("[INFO] Inicializando base de datos H2...");
            DbInitializer.recreateSchemaFromDdl();
            System.out.println("[OK] Base de datos H2 inicializada correctamente.");

            // 2. Construir un EntityManager
            EntityManager em = LocalEntityManagerProvider.em();
            System.out.println("[OK] EntityManager creado correctamente.");

            // 3. Smoke test: Insertar y leer datos de prueba
            System.out.println("[INFO] Ejecutando smoke test...");

            // Crear y persistir un Artist
            Artist artist = new Artist();
            artist.setName("Pink Floyd");
            em.getTransaction().begin();
            em.persist(artist);
            em.getTransaction().commit();
            System.out.println("[OK] Artista 'Pink Floyd' guardado correctamente.");

            // Crear y persistir un Album
            Album album = new Album();
            album.setTitle("The Dark Side of the Moon");
            album.setIdArtist(artist); // Relación con el artista
            em.getTransaction().begin();
            em.persist(album);
            em.getTransaction().commit();
            System.out.println("[OK] Álbum 'The Dark Side of the Moon' guardado correctamente.");

            // Crear y persistir un Track
            Track track = new Track();
            track.setName("Time");
            track.setAlbum(album); // Relación con el álbum
            track.setMilliseconds(421);
            track.setUnitPrice(1.99f);
            em.getTransaction().begin();
            em.persist(track);
            em.getTransaction().commit();
            System.out.println("[OK] Track 'Time' guardado correctamente.");

            // Contar registros en ARTISTS
            Query countArtistsQuery = em.createQuery("SELECT COUNT(a) FROM Artist a");
            Long artistCount = (Long) countArtistsQuery.getSingleResult();
            System.out.printf("[OK] Hay %d artistas en la base de datos.%n", artistCount);

            // Contar registros en ALBUMS
            Query countAlbumsQuery = em.createQuery("SELECT COUNT(a) FROM Album a");
            Long albumCount = (Long) countAlbumsQuery.getSingleResult();
            System.out.printf("[OK] Hay %d álbumes en la base de datos.%n", albumCount);

            // Contar registros en TRACKS
            Query countTracksQuery = em.createQuery("SELECT COUNT(t) FROM Track t");
            Long trackCount = (Long) countTracksQuery.getSingleResult();
            System.out.printf("[OK] Hay %d tracks en la base de datos.%n", trackCount);

            // 4. Mensaje final
            System.out.println("[OK] H2 + DDL inicializados y mapeos JPA verificados.");

        } catch (Exception e) {
            System.err.println("[ERROR] Fallo en el smoke test: " + e.getMessage());
            e.printStackTrace();
        } finally {
            LocalEntityManagerProvider.close(); // Cerrar el EntityManagerFactory
        }     
    }
}
