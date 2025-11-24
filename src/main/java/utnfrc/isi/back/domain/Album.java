package utnfrc.isi.back.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album {
    
    /*(ALBUM_ID, TITLE, ARTIST_ID */

    private Integer idAlbum;
    private String title;
    private Integer idArtist;
}
