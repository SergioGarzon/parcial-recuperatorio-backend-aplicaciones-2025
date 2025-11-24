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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALBUMS")
public class Album {
    
    /*(ALBUM_ID, TITLE, ARTIST_ID */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="album_seq")
    @SequenceGenerator(name = "album_seq", sequenceName = "SEQ_ALBUM_ID", allocationSize = 1)
    @Column(name = "ALBUM_ID", nullable = false)
    private Integer idAlbum;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ARTIST_ID", nullable = false)
    private Artist idArtist;
}
