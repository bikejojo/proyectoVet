/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import Util.Email;

/**
 *
 * @author HP
 */
public interface IEmailEventListener {
    
    
    void onRecieveEmailEvent(List<Email> email);
}
