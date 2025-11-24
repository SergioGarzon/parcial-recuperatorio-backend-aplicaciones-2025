package utnfrc.isi.back.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {

    /*
    PLAYLIST_ID INTEGER      NOT NULL DEFAULT NEXT VALUE FOR SEQ_PLAYLIST_ID,
    NAME        VARCHAR(120), */

    private int idPlaylist;
    private String name;
    
}
