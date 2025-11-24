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
public class Genre {    

    /*
    GENRE_ID INTEGER      NOT NULL DEFAULT NEXT VALUE FOR SEQ_GENRE_ID,
    NAME     VARCHAR(120),
     */

    private Integer idGenre;
    private String name;
}
