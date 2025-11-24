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
public class MediaType {
    /*
     MEDIA_TYPE_ID INTEGER      NOT NULL DEFAULT NEXT VALUE FOR SEQ_MEDIA_TYPE_ID,
    NAME          VARCHAR(120),
     */
    
    private Integer idMediaType;
    private String name;
}
