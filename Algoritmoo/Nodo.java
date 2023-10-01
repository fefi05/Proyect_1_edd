package EDD;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author G. Angelo, S. Estefania y S. Jose 
 * @param <T> 
 */

public class Nodo<T> {

    private T tInfo;
    private Nodo<T> pSig;
    private Lista<T> adyacentes; // Lista de nodos adyacente

    //Constructor
    public Nodo(T elem) {
        this.tInfo = elem;
        this.pSig = null;
        this.adyacentes = new Lista<>();

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

    /**
     * @return the adyacentes
     */
    public Lista<T> getAdyacentes() {
        return adyacentes;
    }

    /**
     * @param adyacentes the adyacentes to set
     */
    public void setAdyacentes(Lista<T> adyacentes) {
        this.adyacentes = adyacentes;
    }

    


    
    
}
