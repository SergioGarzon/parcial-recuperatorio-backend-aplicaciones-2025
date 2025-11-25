package utnfrc.isi.back.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistCsv {

    @CsvBindByName(column = "artist_id")
    private Integer artistId;

    @CsvBindByName(column = "name")
    private String name;
        
    
}
