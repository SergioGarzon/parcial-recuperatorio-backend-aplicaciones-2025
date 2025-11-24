package utnfrc.isi.back.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Track {
    
    /*
     PLAYLIST_TRACK_ID INTEGER NOT NULL DEFAULT NEXT VALUE FOR SEQ_PLAYLIST_TRACK_ID,
    PLAYLIST_ID       INTEGER NOT NULL,
    TRACK_ID          INTEGER NOT NULL,
     */

    private Integer idTrackPlaylist;
    private Integer idPlaylist;
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
