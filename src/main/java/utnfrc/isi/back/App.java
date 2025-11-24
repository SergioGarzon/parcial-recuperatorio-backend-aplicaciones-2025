package utnfrc.isi.back;

import javax.swing.JOptionPane;

import jakarta.persistence.EntityManager;
import utnfrc.isi.back.infra.LocalEntityManagerProvider;
import jakarta.persistence.Query;

/**
 * Proyecto para el parcial de BackEnd de Aplicaciones
 * 
 * @author Sergio Garzón - Legajo 54330
 * @version 1.0
 */
public class App {

    /**
     * Metodo principal de la aplicacion
     * @param args
     */
    public static void main(String[] args) {               

        EntityManager em = LocalEntityManagerProvider.em();
         
        try {
            // Consulta de prueba
            Query query = em.createNativeQuery("SELECT COUNT(*) FROM ARTISTS");
            Long count = (Long) query.getSingleResult();
            System.out.println("Cantidad de artistas en la base de datos: " + count);

            JOptionPane.showMessageDialog(null, "[OK] H2 + DDL inicializados y mapeos JPA verificados.", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            try {
                org.h2.tools.Server.createWebServer("-webPort", "8082", "-webAllowOthers").start();
                System.out.println("Consola de H2 disponible en: http://localhost:8082");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            em.close();
        }        
    }
}
