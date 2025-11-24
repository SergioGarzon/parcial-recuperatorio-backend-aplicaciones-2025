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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ARTISTS")
public class Artist {
    
    // ARTIST_ID, NAME

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="artist_seq")
    @SequenceGenerator(name = "artist_seq", sequenceName = "SEQ_ARTIST_ID", allocationSize = 1)  
    @Column(name = "ARTIST_ID")  
    private Integer idArtist;
    
    @Column(name = "NAME")  
    private String name;
}