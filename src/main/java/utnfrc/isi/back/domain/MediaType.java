package utnfrc.isi.back.domain;

import jakarta.persistence.Entity;
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
@Table(name = "MEDIA_TYPES")
public class MediaType {
    /*
     MEDIA_TYPE_ID INTEGER      NOT NULL DEFAULT NEXT VALUE FOR SEQ_MEDIA_TYPE_ID,
    NAME          VARCHAR(120),
     */
    
    private Integer idMediaType;
    private String name;
}
