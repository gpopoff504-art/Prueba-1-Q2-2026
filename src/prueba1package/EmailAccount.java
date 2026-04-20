/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1package;

/**
 *
 * @author gpopo
 */
public class EmailAccount {

    private String email;
    private String password;
    private String nombre;
    private Email[] inbox;

    public EmailAccount(String email, String password, String nombre) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.inbox = new Email[100];
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean recibirEmail(Email correo) {
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] == null) {
                inbox[i] = correo;
                return true;
            }
        }
        return false;
    }

    public void mostrarInbox() {
        System.out.println("=== INBOX DE: " + email + " | " + nombre + " ===");

        int sinLeer = 0;
        int total = 0;

        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null) {
                String estado = inbox[i].isRead() ? "LEIDO" : "SIN LEER";
             System.out.println(i + " - " + inbox[i].getEmisor() +
                               " - " + inbox[i].getAsunto() +
                               " - " + estado);
                if (!inbox[i].isRead()) sinLeer++;
                total++;
        }
     }

    
        if (total == 0) {
         System.out.println("No hay correos en el inbox.");
         return;
        }

    System.out.println("Sin leer: " + sinLeer);
    System.out.println("Total de correos: " + total);
    }

    public void leerEmail(int posicion) {
        if (posicion < 0 || posicion >= inbox.length || inbox[posicion] == null) {
            System.out.println("Correo No Existe");
            return;
        }
        inbox[posicion].imprimir();
        inbox[posicion].marcarRead();
    }

    public void limpiarInbox() {
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null && inbox[i].isRead()) {
                inbox[i] = null;
            }
        }
        System.out.println("Inbox limpiado.");
    }  
}
