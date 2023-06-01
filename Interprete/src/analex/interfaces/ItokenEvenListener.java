/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analex.interfaces;

import events.TokenEvent;

/**
 *
 * @author HP
 */
public interface ItokenEvenListener {
 
    ///metodos de caso de uso 

    void user(TokenEvent event);
    void persona(TokenEvent event);
    void paciente(TokenEvent event);
    /*void client(TokenEvent event);
    void dpto(TokenEvent event);
    void social(TokenEvent event);
    void schedule(TokenEvent event);
    void notify(TokenEvent event);
    void apartament(TokenEvent event);
    void visit(TokenEvent event);
    void support(TokenEvent event);
    void reserva(TokenEvent event);
    void veterinario(TokenEvent event);
    void reserve(TokenEvent event);
    void veterinario(TokenEvent event);
    void mascota(TokenEvent event);
    */
    void error(TokenEvent event);
}
