package utnfrc.isi.back.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALBUMS")
public class Album {
    
    /*(ALBUM_ID, TITLE, ARTIST_ID */

    private Integer idAlbum;
    private String title;
    private Integer idArtist;
}
