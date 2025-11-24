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
@Table(name = "TRACKS")
public class Track {
    
    /*
     PLAYLIST_TRACK_ID INTEGER NOT NULL DEFAULT NEXT VALUE FOR SEQ_PLAYLIST_TRACK_ID,
    PLAYLIST_ID       INTEGER NOT NULL,
    TRACK_ID          INTEGER NOT NULL,
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="trackplaylist_seq")
    @SequenceGenerator(name = "trackplaylist_seq", sequenceName = "SEQ_PLAYLIST_TRACK_ID", allocationSize = 1)
    @Column(name = "PLAYLIST_TRACK_ID")
    private Integer idTrackPlaylist;

    @Column(name = "PLAYLIST_ID")
    private Integer idPlaylist;

    @Column(name = "TRACK_ID")
    private Integer idTrack;

    /* 
    public double getDurationInMinutes() {
        return milliseconds != null ? milliseconds / 60000.0 : 0.0;
    }

    public boolean hasValidPrice() {
        return unitPrice != null && unitPrice.doubleValue() > 0.0;
    }
    */
}
