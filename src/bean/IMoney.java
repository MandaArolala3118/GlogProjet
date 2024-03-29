/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bean;

/**
 *
 * @author BEST
 */
public interface IMoney {
    int amount();
    String currency();
    IMoney add(IMoney m);
    String typeOf();
}

