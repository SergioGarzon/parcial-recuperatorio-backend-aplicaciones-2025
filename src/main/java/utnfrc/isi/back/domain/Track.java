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
@Table(name = "TRACKS")
public class Track {
    
    /*    
    TRACK_ID      INTEGER        NOT NULL DEFAULT NEXT VALUE FOR SEQ_TRACK_ID,
    NAME          VARCHAR(200)   NOT NULL,
    ALBUM_ID      INTEGER,
    MEDIA_TYPE_ID INTEGER        NOT NULL,
    GENRE_ID      INTEGER,
    COMPOSER      VARCHAR(220),
    MILLISECONDS  INTEGER        NOT NULL,
    BYTES         INTEGER,
    UNIT_PRICE    NUMERIC(10, 2) NOT NULL,
    */ 

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "track_seq")
    @SequenceGenerator(name = "track_seq", sequenceName = "SEQ_TRACK_ID", allocationSize = 1)
    @Column(name = "TRACK_ID")
    private Integer idTrack;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ALBUM_ID")
    private Album album;  

    @Column(name = "MEDIA_TYPE_ID", nullable = false)
    private Integer mediaTypeId;

    @Column(name = "GENRE_ID")
    private Integer genreId;

    @Column(name = "COMPOSER")
    private String composer;

    @Column(name = "MILLISECONDS", nullable = false)
    private Integer milliseconds;

    @Column(name = "BYTES")
    private Integer bytes;

    @Column(name = "UNIT_PRICE", nullable = false)
    private Float unitPrice;

    public double getDurationInMinutes() {
        return milliseconds != null ? milliseconds / 60000.0 : 0.0;
    }

    public boolean hasValidPrice() {
        return unitPrice != null && unitPrice.doubleValue() > 0.0;
    }
    
}
