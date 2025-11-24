package utnfrc.isi.back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="playlist_seq")
    @SequenceGenerator(name = "playlist_seq", sequenceName = "SEQ_PLAYLIST_ID", allocationSize = 1)
    @Column(name = "PLAYLIST_ID")
    private Integer idPlaylist;

    @Column(name = "NAME")
    private String name;
    
}
