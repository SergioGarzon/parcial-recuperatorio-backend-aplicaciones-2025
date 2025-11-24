package utnfrc.isi.back;

import utnfrc.isi.back.domain.Artist;
import utnfrc.isi.back.domain.Album;
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
            System.out.println("\nConsola de H2 disponible en: http://localhost:8082");
            System.out.println("\nRecorda las credenciales para acceder a la base de datos \n");
            System.out.println("Controlador: org.h2.Driver");
            System.out.println("URL JDBC: jdbc:h2:mem:backdb");
            System.out.println("Nombre de usuario: sa");
            System.out.println("Contraseña: (Ninguna)");
            System.out.println("\n");
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
}
