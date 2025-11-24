package utnfrc.isi.back;

import utnfrc.isi.back.domain.Artist;
import utnfrc.isi.back.infra.LocalEntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.Scanner;

/**
 * Proyecto para el parcial de BackEnd de Aplicaciones
 * 
 * @author Sergio Garzón - Legajo 54330
 * @version 1.0
 */
public class App {

    private static EntityManager em;

    private App() {
        App.em = LocalEntityManagerProvider.em();
    }

    /**
     * Metodo principal de la aplicacion
     * @param args
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

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
            System.out.print("Ingrese la opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    if(!control) {
                        new App();
                        System.out.println("[OK] H2 + DDL inicializados y mapeos JPA verificados.");
                        control = true;
                    }                    
                    break;
                case 2: 
                    if(control) 
                        mostrarBD();
                    else 
                        System.out.println("Se debe crear primero, poner opción 1");
                    break; 
                case 3:
                    if(control) 
                        System.out.println("HOla");
                    else 
                        System.out.println("Se debe crear primero, poner opción 1");
                    break;
                default: 
                    System.out.println("Opcion incorrecta! \n\n");
                    break;

                case 9:
                    LocalEntityManagerProvider.close();
                    System.out.println("Hasta luego");
                    return;                              
                
            }
            
        } while(opcion != 9);

    }

    private static void mostrarBD() {
        try {
            org.h2.tools.Server.createWebServer("-webPort", "8082", "-webAllowOthers").start();
            System.out.println("Consola de H2 disponible en: http://localhost:8082");
        } catch (Exception e) {
            System.err.println("No se pudo iniciar el servidor web de H2: " + e.getMessage());
            e.printStackTrace();
        }
    }


    /*
    try {
            EntityManager em = LocalEntityManagerProvider.em();
            

            Artist artist = new Artist();
            artist.setName("Pink Floyd");
            em.getTransaction().begin();
            em.persist(artist);
            em.getTransaction().commit();
            System.out.println("[OK] Artista 'Pink Floyd' guardado correctamente.");

            Query countArtistsQuery = em.createQuery("SELECT COUNT(a) FROM Artist a");
            Long artistCount = (Long) countArtistsQuery.getSingleResult();
            System.out.printf("[OK] Hay %d artistas en la base de datos.%n", artistCount);

            

        } catch (Exception e) {
            System.err.println("[ERROR] Fallo en el smoke test: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "[ERROR] Fallo en el smoke test: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            LocalEntityManagerProvider.close(); 
        }
             */
}
