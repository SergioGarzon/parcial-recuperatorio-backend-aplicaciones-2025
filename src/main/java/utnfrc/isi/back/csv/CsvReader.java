package utnfrc.isi.back.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReader {

    public static List<ArtistCsv> readArtists(String filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(Path.of(filePath))) {
            return new CsvToBeanBuilder<ArtistCsv>(reader)
                    .withType(ArtistCsv.class)
                    .withSeparator(',') // o el separador que corresponda
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        }
    }
}