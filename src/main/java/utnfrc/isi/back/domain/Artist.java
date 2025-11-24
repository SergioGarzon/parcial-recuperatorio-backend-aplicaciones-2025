package utnfrc.isi.back.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Artist {
    

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="artist_seq")
    @SequenceGenerator(name = "artist_seq", sequenceName = "SEQ_ARTIST_ID", allocationSize = 1)
    */
    private int idArtist;
    private String name;
}