
import EDD.Lista;
import EDD.Nodo;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author joses
 */
public class Funciones {

    public void escribir_txt(Lista ListaVertices) {
        String usuarios = "usuarios \n";
        String relaciones = "relaciones \n";
        if (!ListaVertices.esVacio()) {
            Nodo aux = ListaVertices.getpPrim();
            for (int i = 0; i < ListaVertices.getiN(); i++) {
                usuarios += aux.gettInfo() + "\n";
                //
                aux = aux.getpSig();

            }
        }
        try{
            PrintWriter pw = new PrintWriter("test\\usuarios.txt");
            pw.print(usuarios);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitoso");
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
    
    

}
