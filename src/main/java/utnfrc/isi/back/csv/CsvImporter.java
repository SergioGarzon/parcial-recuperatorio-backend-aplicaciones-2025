package utnfrc.isi.back.csv;

import utnfrc.isi.back.domain.Artist;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CsvImporter {

    public static void importArtists(EntityManager em, String filePath) {
        try {
            List<ArtistCsv> artistCsvs = CsvReader.readArtists(filePath);
            
            em.getTransaction().begin();

            for (ArtistCsv artistCsv : artistCsvs) {
                Artist artist = new Artist();
                artist.setIdArtist(artistCsv.getArtistId());
                artist.setName(artistCsv.getName());
                em.merge(artist); // Usar merge() en lugar de persist()
            }

            em.getTransaction().commit();

            System.out.println("Artistas importados correctamente.");
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al importar artistas: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
