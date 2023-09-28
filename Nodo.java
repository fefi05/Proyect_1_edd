/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author G. Angelo, S. Estefania y S. Jose 
 */

public class Nodo<T> {

    private T tInfo;
    private Nodo<T> pSig;

    //Constructor
    public Nodo(T elem) {
        this.tInfo = elem;
        this.pSig = null;

    }
    
    //Gets & Sets

    /**
     * @return the tInfo
     */
    public T gettInfo() {
        return tInfo;
    }

    /**
     * @param tInfo the tInfo to set
     */
    public void settInfo(T tInfo) {
        this.tInfo = tInfo;
    }

    /**
     * @return the pSig
     */
    public Nodo<T> getpSig() {
        return pSig;
    }

    /**
     * @param pSig the pSig to set
     */
    public void setpSig(Nodo<T> pSig) {
        this.pSig = pSig;
    }
    
    
}
