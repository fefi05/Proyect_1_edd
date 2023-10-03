
import EDD.NuevoGrafo;

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

        NuevoGrafo miGrafo = new NuevoGrafo();

        miGrafo.agregarNodo("@jose");
        miGrafo.agregarNodo("@angelo");
        miGrafo.agregarNodo("@estefania");
        miGrafo.agregarNodo("@guillen");
        miGrafo.agregarNodo("@manuel");

        miGrafo.conectarNodos("@angelo", "@guillen");
        miGrafo.conectarNodos("@guillen", "@angelo");
//        miGrafo.conectarNodos("@guillen", "@angelo");
//        miGrafo.conectarNodos("@estefania", "@angelo");

//        System.out.println("Componentes fuertemente conexos:");
//        Graph_1 g = new Graph_1(5);
//        g.addEdge(0, 1);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(1, 3);
//        g.addEdge(3, 4);
//
//        System.out.println("Componentes fuertemente conexos:");
//        g.printSCCs();

//        miGrafo.conectarNodos("@angelo", "@jose");
//        miGrafo.conectarNodos("@estefania", "@guillen");
//        miGrafo.conectarNodos("@estefania", "@jose");
//        miGrafo.conectarNodos("@jose", "@jose");
//        miGrafo.desconectarNodos("@estefania", "@jose");
//        miGrafo.desconectarNodos("@estefania", "@jose");
        miGrafo.imprimirGrafo();
        miGrafo.kosaraju();

        //miGrafo.transpuesto().imprimirGrafo();
        //miGrafo.imprimirSCCs();
    }

}
