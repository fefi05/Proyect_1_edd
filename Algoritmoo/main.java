/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author PC
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Grafo miGrafo = new Grafo(10, true);
        
        miGrafo.insertaVertice(6);
        miGrafo.insertaArista(0, 1);
        miGrafo.insertaArista(1, 2);
        miGrafo.insertaArista(2, 0);
        miGrafo.insertaArista(1, 3);
        miGrafo.insertaArista(3, 4);

        
        miGrafo.imprimirGrafo();
        miGrafo.transpuesto().imprimirGrafo();
        
        miGrafo.imprimirSCCs();
        
        Graph_1 g = new Graph_1(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 3);
        g.addEdge(3, 4);

        System.out.println("Componentes fuertemente conexos:");
        g.printSCCs();
        
        
  
    }
    
}
