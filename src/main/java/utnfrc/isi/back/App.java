package utnfrc.isi.back;

import utnfrc.isi.back.domain.Artist;
import utnfrc.isi.back.domain.Genre;
import utnfrc.isi.back.domain.MediaType;
import utnfrc.isi.back.domain.Album;
import utnfrc.isi.back.domain.Track;
import utnfrc.isi.back.infra.LocalEntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;


/**
 * Proyecto para el parcial de BackEnd de Aplicaciones
 * 
 * @author Sergio Garzón - Legajo 54330
 * @version 1.0
 */
public class App {

    private static EntityManager em;
    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    private App() {
        App.em = LocalEntityManagerProvider.em();
    }

    /**
     * Metodo principal de la aplicacion
     * @param args
     */
    public static void main(String[] args) throws IOException {

        new App();

        int opcion = 0;
        boolean control = false;

        do {
            System.out.println("\n*****************MENU DE OPCIONES*****************");
            System.out.println("1) Cargar la base de datos en memoria");
            System.out.println("2) Verificar la base de datos en el navegador");
            System.out.println("3) Verificar cantidad de registros en Artists");
            System.out.println("4) Verificar cantidad de registros en Genres");
            System.out.println("5) Cargar datos de pruebas de Artists");
            System.out.println("6) Cargar datos de pruebas de Album");
            System.out.println("7) Cargar datos de pruebas de Track");
            System.out.println("9) Salir del sistema");
            System.out.print("\nIngrese la opción: ");
            opcion = Integer.parseInt(entrada.readLine());

            switch (opcion) {
                case 1:
                    if(!control) {
                        new App();
                        System.out.println("\n[OK] H2 + DDL inicializados y mapeos JPA verificados.");
                        control = true;
                    }                    
                    break;
                case 2: 
                    if(control) 
                        mostrarBD();
                    else 
                        System.out.println("\nSe debe crear primero la base de datos, poner opción 1");
                    break; 
                case 3:
                    if(control) 
                        verificarCantRegistrosArtistas();
                    else 
                        System.out.println("\nSe debe crear primero la base de datos, poner opción 1");
                    break;
                case 4:
                    if(control) 
                        verificarCantRegistrosGenres();
                    else 
                        System.out.println("\nSe debe crear primero la base de datos, poner opción 1");
                    break;  
                case 5:
                    if(control) 
                        cargarArtists();
                    else 
                        System.out.println("\nSe debe crear primero la base de datos, poner opción 1");
                    break; 
                case 6:
                    if(control) 
                        cargarAlbum();                    
                    else 
                        System.out.println("\nSe debe crear primero la base de datos, poner opción 1");
                    break; 
                case 7:
                    if(control) 
                        cargarTrack();                    
                    else 
                        System.out.println("\nSe debe crear primero la base de datos, poner opción 1");
                    break;
                case 9:
                    LocalEntityManagerProvider.close();
                    System.out.println("\nHasta luego");
                    return;                              
                default: 
                    System.out.println("\nOpcion incorrecta! \n\n");
                    break;
            }
            
        } while(opcion != 9);

    }

    private static void mostrarBD() {
        try {
            org.h2.tools.Server.createWebServer("-webPort", "8082", "-webAllowOthers").start();
            System.out.println("""
                \nConsola de H2 disponible en: http://localhost:8082
                Recorda las credenciales para acceder a la base de datos \n
                Controlador: org.h2.Driver
                URL JDBC: jdbc:h2:mem:backdb
                Nombre de usuario: sa
                Contraseña: (Ninguna)
                \n""");
        } catch (Exception e) {
            System.err.println("\nNo se pudo iniciar el servidor web de H2: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void verificarCantRegistrosArtistas() {
        try {
            Query countArtistsQuery = em.createQuery("SELECT COUNT(a) FROM Artist a");
            Long artistCount = (Long) countArtistsQuery.getSingleResult();
            System.out.printf("\n[OK] Hay %d artistas en la base de datos.%n", artistCount);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

     private static void verificarCantRegistrosGenres() {
        try {
            Query countGenresQuery = em.createQuery("SELECT COUNT(g) FROM Genre g");
            Long genresCount = (Long) countGenresQuery.getSingleResult();
            System.out.printf("\n[OK] Hay %d genres en la base de datos.%n", genresCount);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private static void cargarArtists() {
        try {
            Artist artist = new Artist();

            String nombre = "";
            System.out.print("Ingrese el nombre del artista a cargar: ");
            nombre = entrada.readLine();

            artist.setName(nombre);
            em.getTransaction().begin();
            em.persist(artist);
            em.getTransaction().commit();
            System.out.println("\n[OK] Artista " + nombre + " guardado correctamente.");
            System.out.println("\nRecorda que podes consultar en la base de datos");            

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    
    private static void cargarAlbum() {
        try {
            System.out.println("\nPara cargar datos de los Albums, primero debemos conocer los datos de los artistas");

            Query query = em.createQuery("SELECT a FROM Artist a", Artist.class);
            List<Artist> artists = query.getResultList();

            System.out.println("\nLista de artistas en la base de datos:");
            
            for (Artist a : artists) {
                System.out.println("ID: " + a.getIdArtist() + ", Nombre: " + a.getName());
            }           

            Album artist = new Album();

            String nombre = "", nombreArtista = "";
            int numeroArtista = 0;

            System.out.print("\n\nIngrese el nombre del album a cargar: ");
            nombre = entrada.readLine();

            System.out.print("Ingrese el número de artista a quien le corresponde el album: ");
            numeroArtista = Integer.parseInt(entrada.readLine());

            artist.setTitle(nombre);

            for (Artist a : artists) {
                if(a.getIdArtist() == numeroArtista) {
                    nombreArtista = a.getName();
                    artist.setIdArtist(a);
                }                    
            } 
            
            em.getTransaction().begin();
            em.persist(artist);
            em.getTransaction().commit();
            System.out.println("\n[OK] Album " + nombre + " de artista " + nombreArtista + " guardado correctamente.");
            System.out.println("\nRecorda que podes consultar en la base de datos");

        } catch (Exception e) {
            System.err.println("\nNo se pudo cargar el album " + e.getMessage());
            e.printStackTrace();
        } 
    }    

    private static void cargarTrack() throws IOException {
        try {
            System.out.println("\nPara cargar datos de los Track, primero se deben cargar por defecto algunos Genres y MusicTypes");

            // Carga de datos de las tablas por separado
            cargaGenres();
            cargaMediaType();
            
            // Muestro los datos de los generos
            Query query1 = em.createQuery("SELECT g FROM Genre g", Genre.class);
            List<Genre> genreList = query1.getResultList();

            System.out.println("\nLista de genres en la base de datos:");
            
            for (Genre g : genreList) {
                System.out.println("ID: " + g.getIdGenre() + ", Nombre: " + g.getName());
            }     

            // Muestro los datos de los MediaTypes
            Query query2 = em.createQuery("SELECT m FROM MediaType m", MediaType.class);
            List<MediaType> mediaTypeList = query2.getResultList();

            System.out.println("\nLista de MediaTypes en la base de datos:");
            
            for (MediaType m : mediaTypeList) {
                System.out.println("ID: " + m.getIdMediaType() + ", Nombre: " + m.getName());
            }     

            // Muestro los datos de los Albums
            Query query3 = em.createQuery("SELECT al FROM Album al", Album.class);
            List<Album> albumData = query3.getResultList();

            System.out.println("\nLista de Albums en la base de datos:");
            
            for (Album ad : albumData) {
                System.out.println("ID: " + ad.getIdAlbum() + ", Nombre: " + ad.getTitle() + ", Número de artista: " + ad.getIdArtist());
            }  
            
            Track track = new Track();

            String nombreTrack = "", composerName = "";
            int codigoAlbum = 0, codigoMediaType = 0, codigoGenre = 0, durationTrack = 0, byteTrack = 0;
            float unitPrice = 0f;
        
            System.out.print("\nIngrese el nombre del track: ");
            nombreTrack = entrada.readLine();

            track.setName(nombreTrack);

            do {
                System.out.print("Ingrese el código del album: ");
                codigoAlbum = Integer.parseInt(entrada.readLine());

                for (Album al : albumData) {
                    if(al.getIdAlbum() == codigoAlbum)
                        track.setAlbum(al);
                    else 
                        codigoAlbum = 0;                  
                } 

                if(codigoAlbum == 0)
                    System.out.println("Código de album incorrecto!");
            } while(codigoAlbum == 0);

            do {
                System.out.print("Ingrese el código del MediaType: ");
                codigoMediaType = Integer.parseInt(entrada.readLine());

                for (MediaType mt : mediaTypeList) {
                    if(mt.getIdMediaType() == codigoMediaType)
                        track.setMediaTypeId(mt);
                    else 
                        codigoMediaType = 0;                  
                } 

                if(codigoMediaType == 0)
                    System.out.println("Código de MediaType incorrecto!");
            } while(codigoMediaType == 0);

            do {
                System.out.print("Ingrese el código del Genre: ");
                codigoGenre = Integer.parseInt(entrada.readLine());

                for (Genre gnr : genreList) {
                    if(gnr.getIdGenre() == codigoGenre)
                        track.setGenreId(gnr);
                    else 
                        codigoGenre = 0;                  
                } 

                if(codigoGenre == 0)
                    System.out.println("Código de Genre incorrecto!");
            } while(codigoGenre == 0);

            System.out.print("Ingrese el nombre del compositor: ");
            composerName = entrada.readLine();

            track.setComposer(composerName);

            System.out.print("Ingrese la duración en milisegundos: ");
            durationTrack = Integer.parseInt(entrada.readLine());
            
            track.setMilliseconds(durationTrack);

            System.out.print("Ingrese los bytes: ");
            byteTrack = Integer.parseInt(entrada.readLine());

            track.setBytes(byteTrack);

            System.out.print("Ingrese unit price: ");
            unitPrice = Float.parseFloat(entrada.readLine());

            track.setUnitPrice(unitPrice);

            em.getTransaction().begin();
            em.persist(track);
            em.getTransaction().commit();

            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void cargaGenres() {
        try {
            Genre genre = new Genre();
            genre.setName("Folklore");        
            em.getTransaction().begin();
            em.persist(genre);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void cargaMediaType() {
        try {
            MediaType mediaType = new MediaType();
            mediaType.setName("Media type 1");   
            em.getTransaction().begin();
            em.persist(mediaType);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
