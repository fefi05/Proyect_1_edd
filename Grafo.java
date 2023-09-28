/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author G. Angelo, S. Estefania y S. Jose
 */

public class Grafo{

    // DEFINICIÓN DE ATRIBUTOS DE LA CLASE GRAFO (USANDO MATRIZ DE ADYACENCIA)
    private int numVertices; // Número de vértices del grafo.
    private Lista listaAdy[]; // Vector de listas de adyacencias del grafo.

    // CONSTRUCTORES DE LA CLASE
    //Constructor
    public Grafo(int n, boolean d) {
        numVertices = 0;
        listaAdy = new Lista[n];
    }

    //MÉTODOS DE LA CLASE
    
    //Puede que para los metodos de insercion y eliminacion haga falta modificarlos para que sean en base a tInfo del nodo
    
    //Insertar arista 
    public void insertaArista(int i, int j) {
        if (i >= getNumVertices()) {
            System.out.println("Error, no existe el vértice en el grafo");
        } else {
            getListaAdy()[i].insertar(j);
        }
    }

    //Eliminar arista
    public void eliminaArista(int i, int j) {
        if (j >= getNumVertices()) {
            System.out.println("Error, no existe el vértice en el grafo");
        } else {
            getListaAdy()[i].eliminar(j);
        }
    }

    //Insertar vértice // n = número de vertices que se desea añadir al grafo
    public void insertaVertice(int n) {
        for (int i = getNumVertices(); i < getNumVertices() + n; i++) {
            getListaAdy()[i] = new Lista();
        }
        setNumVertices(getNumVertices() + n);
    }

    // Eliminar vertice
    public void eliminarVertice(int v) {
        if (v >= getNumVertices()) {
            System.out.println("Error, no existe el vértice en el grafo");
            return;
        }

        // Elimina todas las aristas asociadas a este vértice
        for (int i = 0; i < getNumVertices(); i++) {
            getListaAdy()[i].eliminar(v); // Elimina la arista desde otros vértices hacia v
        }

        // Desplaza las listas de adyacencia
        for (int i = v; i < getNumVertices() - 1; i++) {
            getListaAdy()[i] = getListaAdy()[i + 1];
        }
        setNumVertices(getNumVertices() - 1); // 
        getListaAdy()[getNumVertices()] = null; // Eliminar referencia a la última lista
    }

    //Grado de entrada (Seguidores de un usuario)
    public int gradoIn(int v) {
        int gIn = 0;
        for (int i = 0; i < getNumVertices(); i++) {
            if (i != v) {
                if (getListaAdy()[i].busqueda(v)) {
                    gIn++;
                }
            }
        }
        return gIn;
    }

    //Grado de salida (Seguidos por un usuario)
    public int gradoOut(int i) {
        int gOut = 0;
        Nodo pAux = getListaAdy()[i].getpPrim();
        while (pAux != null) {
            gOut++;
            pAux = pAux.getpSig();
        }
        return gOut;
    }

    public int buscarVertice(Object valor) {
        for (int i = 0; i < getNumVertices(); i++) {
            Lista lista = getListaAdy()[i];
            Nodo actual = lista.getpPrim();
            while (actual != null) {
                if (actual.gettInfo().equals(valor)) {
                    return i; // Retorna el índice del vértice en el que se encontró el valor
                }
                actual = actual.getpSig();
            }
        }
        return -1; // Retorna -1 si no se encuentra el valor en ningún vértice
    }

    //Imprimir grafo
    public void imprimirGrafo() {
        System.out.println("El grafo contiene " + getNumVertices() + " vértices: \n");
        for (int i = 0; i < getNumVertices(); i++) {
            System.out.print("vértice " + i + ": ");
            escribir(getListaAdy()[i]);
        }
    }

    // Metodo auxiliar escribir
    public void escribir(Lista lista) {
        Nodo pAux;
        pAux = lista.getpPrim();
        while (pAux != null) {
            System.out.print(pAux.gettInfo() + ", ");
            pAux = pAux.getpSig();
        }
        System.out.println("FIN");
    }
    
    //Gets & Sets

    /**
     * @return the numVertices
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * @param numVertices the numVertices to set
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    /**
     * @return the listaAdy
     */
    public Lista[] getListaAdy() {
        return listaAdy;
    }

    /**
     * @param listaAdy the listaAdy to set
     */
    public void setListaAdy(Lista[] listaAdy) {
        this.listaAdy = listaAdy;
    }
    
    
}
