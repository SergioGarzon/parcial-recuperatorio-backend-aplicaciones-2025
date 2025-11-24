package utnfrc.isi.back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "GENRES")
public class Genre {    

    /*
    GENRE_ID INTEGER      NOT NULL DEFAULT NEXT VALUE FOR SEQ_GENRE_ID,
    NAME     VARCHAR(120),
     */

    @Id
    @Column(name = "GENRE_ID")
    private Integer idGenre;

    @Column(name = "NAME")
    private String name;
}
