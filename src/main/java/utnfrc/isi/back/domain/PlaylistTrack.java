package utnfrc.isi.back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "PLAYLIST_TRACK")
public class PlaylistTrack {
    /*
    PLAYLIST_TRACK_ID INTEGER NOT NULL DEFAULT NEXT VALUE FOR SEQ_PLAYLIST_TRACK_ID,
    PLAYLIST_ID       INTEGER NOT NULL,
    TRACK_ID          INTEGER NOT NULL,
     */
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playlisttrack_seq")
    @SequenceGenerator(name = "playlisttrack_seq", sequenceName = "SEQ_PLAYLIST_TRACK_ID", allocationSize = 1)
    @Column(name = "PLAYLIST_TRACK_ID")
    private Integer idPlaylistTrack;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PLAYLIST_ID", nullable = false)
    private Playlist playlist; 

    @ManyToOne(optional = false)
    @JoinColumn(name = "TRACK_ID", nullable = false)
    private Track track;  

}