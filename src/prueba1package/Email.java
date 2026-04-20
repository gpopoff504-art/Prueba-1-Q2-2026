/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1package;

/**
 *
 * @author gpopo
 */
public class Email {
    String emisorEmail;
    String asunto;
    String message;
    boolean read = false;
    
    public Email(String emisorEmail, String asunto, String message){
        this.emisorEmail = emisorEmail;
        this.asunto = asunto;
        this.message = message;
        this.read = false;
    }
    
    public String getEmisor() {
        return emisorEmail;
    }
    
    public String getAsunto(){
        return asunto;
    }
    
    public String getMessage(){
        return message;
    }
    
    public boolean isRead(){
        return read;
    }
    
    //Marcar como leido 
    public void marcarRead() {
        this.read = true;
    }
    
    // Imprimir correo 
    public void imprimir() {
        System.out.println("DE: " + emisorEmail);
        System.out.println("ASUNTO: " + asunto);
        System.out.println(message);
    }
    
}
