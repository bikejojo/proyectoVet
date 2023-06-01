/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coneccionnucleo;

import Util.Email;
import comunicacion.MailVerificationThread;
import comunicacion.SendEmailThread;
import interfaces.IEmailEventListener;
import java.util.List;

/**
 *
 * @author HP
 */
public class ConeccionNucleo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //prueva de escuchador de correos
        MailVerificationThread mail= new MailVerificationThread();
        
        mail.setEmailEventListener(new IEmailEventListener() {
            @Override
            public void onRecieveEmailEvent(List<Email> emails) {
                //evento
                for (Email email : emails) {
                    System.out.println(email);
                }
                
            }
        });
        Thread thread = new Thread(mail);
        thread.setName("Mail Verification Thread");
        thread.start();
            /*
        Email emailObjet = new Email("jakeli1997.jcs@gmail.com", Email.SUBJECT, "Peticion Prueva realizada correctamente");
        SendEmailThread sendEmail= new SendEmailThread(emailObjet);
        
        Thread thread = new Thread(sendEmail);
        thread.setName("Send Mail Thread");
        thread.start();
        */
    }
    
}
