package utnfrc.isi.back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Id
    @Column(name = "ALBUM_ID", nullable = false)
    private Integer idAlbum;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "ARTIST_ID", nullable = false)
    private Integer idArtist;
}
