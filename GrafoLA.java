/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author joses
 */
public class GrafoLA {

    // DEFINICIÓN DE ATRIBUTOS DE LA CLASE GRAFO (USANDO MATRIZ DE ADYACENCIA)
    private boolean dirigido; // Indica si es dirigido o no.
    private int maxNodos; // Tamaño máximo de la tabla.
    private int numVertices; // Número de vértices del grafo.
    private Lista listaAdy[]; // Vector de listas de adyacencias del grafo.

    // CONSTRUCTORES DE LA CLASE
    // Se utiliza para crear un grafo vacío, con un tamaño máximo y número de vértices igual a 0. Se pasa como argumento un booleano que indica si se trata de un grafo dirigido o no dirigido.
    public GrafoLA(boolean d) {
        maxNodos = numVertices = 0;
        dirigido = d;
    }

    public GrafoLA(int n, boolean d) {
        dirigido = d;
        maxNodos = n;
        numVertices = 0;
        listaAdy = new Lista[n];
    }

    //MÉTODOS DE LA CLASE
    //Insertar arista 
    public void insertaArista(int i, int j) {
        if (i >= numVertices) {
            System.out.println("Error, no existe el vértice en el grafo");
        } else {
            listaAdy[i].insertar(j,false);
            if (!dirigido) {
                listaAdy[j].insertar(j,false);
            }
        }
    }

    //Eliminar arista
    public void eliminaArista(int i, int j) {
        if (j >= numVertices) {
            System.out.println("Error, no existe el vértice en el grafo");
        } else {
            listaAdy[i].eliminar(j);
            if (!dirigido) {
                listaAdy[j].eliminar(i);
            }
        }
    }

    //Insertar vértice
    public void insertaVertice(int n) {
        if (n > maxNodos - numVertices) {
            System.out.println("Error, se supera el número de nodos máximo del grafo");
        } else {
            for (int i = numVertices; i < numVertices + n; i++) {
                listaAdy[i] = new Lista();
            }
        }
        numVertices += n;
    }

    // No hay funcion para eliminar vértices aún
    
    //Grado de entrada (Seguidores de un usuario)
    public int gradoIn(int v) {
        int gIn = 0;
        for (int i = 0; i < numVertices; i++) {
            if (i != v) {
                if (listaAdy[i].busqueda(v)) {
                    gIn++;
                }
            }
        }
        return gIn;
    }

    //Grado de salida (Seguidos por un usuario)
    public int gradoOut(int i) { 
        int gOut = 0;
        Nodo pAux = listaAdy[i].primero(); 
        while (pAux != null) {
            gOut++;
            pAux = pAux.proximo();
        }
        return gOut;
    }

    //Tamano del grafo
    public int tamano() {
        int tm = 0;
        for (int i = 0; i < numVertices; i++) {
            tm += numElementos(listaAdy[i]);
        }
        if (!dirigido) {
            tm = tm / 2;
        }
        return tm;
    }

    public int numElementos(Lista lista) {
        Nodo aux = lista.primero(); // Cambiado a getFirst.
        int resul = 0;
        while (aux != null) {
            resul += 1;
            aux = aux.proximo(); // Cambiado a getNext.
        }
        return resul;
    }

    //Imprimir tabla matriz
    public void imprimirGrafo() {
        System.out.println("Tamaño máximo del grafo: " + maxNodos + "\n");
        System.out.println("El grafo contiene " + numVertices + " vértices: \n");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("vértice " + i + ": ");
            escribir(listaAdy[i]);
        }
    }

    public void escribir(Lista lista) {
        Nodo pAux;
        pAux = lista.primero(); // Cambiado a getFirst.
        while (pAux != null) {
            System.out.print(pAux.getInfo() + ", "); // Cambiado a getInfo().
            pAux = pAux.proximo(); // Cambiado a getNext.
        }
        System.out.println("FIN");
    }
}
