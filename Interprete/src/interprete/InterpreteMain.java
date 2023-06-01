/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interprete;

import analex.Interpreter;
import analex.interfaces.ItokenEvenListener;
import events.TokenEvent;

/**
 *
 * @author HP
 */
public class InterpreteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String comando="PACIENTE_ADD<Firulay,canina,salchicha,macho,megro,12-05-2020,1,null>";
        String correo="jakeli1997.jcs@gmail.com";
        Interpreter interprete = new Interpreter(comando,correo);
        
        interprete.setListener(new ItokenEvenListener() {
            @Override
            public void user(TokenEvent event) {
                System.out.println("CU: Users");
                System.out.println(event);
            }

            @Override
            public void persona(TokenEvent event) {
                System.out.println("CU: Persona");
                System.out.println(event);
            }

            @Override
            public void paciente(TokenEvent event) {
                System.out.println("CU: Paciente");
                System.out.println(event);
            }

            @Override
            public void error(TokenEvent event) {
                System.out.println("Desconocido");
                System.out.println(event);
            }
        });
    
        
        Thread thread = new Thread(interprete);
        thread.setName("Interprete Thread");
        thread.start();

    }
    
}
