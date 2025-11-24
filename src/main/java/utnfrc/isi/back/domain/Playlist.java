package utnfrc.isi.back.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PLAYLISTS")
public class Playlist {

    /*
    PLAYLIST_ID INTEGER      NOT NULL DEFAULT NEXT VALUE FOR SEQ_PLAYLIST_ID,
    NAME        VARCHAR(120), */

    private Integer idPlaylist;
    private String name;
    
}
