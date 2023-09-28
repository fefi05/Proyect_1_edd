/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 * @param <T>
 */
public class NodoPila <T> {
    
    private Object tInfo;
    NodoPila <T> pSig;
    
    public NodoPila(Object tInfo){
        this.tInfo = tInfo;
        pSig = null;
    }

    public Object gettInfo() {
        return tInfo;
    }

    public void settInfo(Object tInfo) {
        this.tInfo = tInfo;
    }

    public NodoPila<T> getpSig() {
        return pSig;
    }

    public void setpSig(NodoPila<T> pSig) {
        this.pSig = pSig;
    }
    
    
    
}
