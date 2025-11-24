package utnfrc.isi.back.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    
    /*(ALBUM_ID, TITLE, ARTIST_ID */

    private int idAlbum;
    private String title;
    private int idArtist;
}
