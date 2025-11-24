package utnfrc.isi.back.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MediaType {
    /*
     MEDIA_TYPE_ID INTEGER      NOT NULL DEFAULT NEXT VALUE FOR SEQ_MEDIA_TYPE_ID,
    NAME          VARCHAR(120),
     */
    
    private Integer idMediaType;
    private String name;
}
