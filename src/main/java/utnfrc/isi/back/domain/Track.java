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

    @ManyToOne(optional = false)
    @JoinColumn(name = "MEDIA_TYPE_ID", nullable = false)
    private MediaType mediaTypeId;

    @ManyToOne(optional = true)
    @JoinColumn(name = "GENRE_ID")
    private Genre genreId;

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
