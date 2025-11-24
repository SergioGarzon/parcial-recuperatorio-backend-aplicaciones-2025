package utnfrc.isi.back.domain;

import jakarta.persistence.Column;
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
@Table(name = "PLAYLIST_TRACK")
public class PlaylistTrack {
    /*
    PLAYLIST_TRACK_ID INTEGER NOT NULL DEFAULT NEXT VALUE FOR SEQ_PLAYLIST_TRACK_ID,
    PLAYLIST_ID       INTEGER NOT NULL,
    TRACK_ID          INTEGER NOT NULL,
     */
    
    @Column(name = "PLAYLIST_TRACK_ID")
    private Integer idPlaylistTrack;

    @Column(name = "PLAYLIST_ID")
    private Integer idPlaylist;

    @Column(name = "TRACK_ID")
    private Integer idTrack;

}