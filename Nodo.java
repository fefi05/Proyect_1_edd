/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author joses
 */
public class Nodo<T> {
        T tInfo;
        Nodo<T> pNext;
        Nodo<T> pPrev;

        Nodo(T i) {
            this.tInfo = i;
            this.pNext = null;
            this.pPrev = null;
        }
    }
