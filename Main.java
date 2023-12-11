//Pérez Talavera Alejandro de Jesús
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ABB arbol = new ABB();

        // Insertar valores 9,2,1,16,6,11,8,4
        arbol.insertarValor(9);
        arbol.insertarValor(2);
        arbol.insertarValor(1);
        arbol.insertarValor(16);
        arbol.insertarValor(6);
        arbol.insertarValor(11);
        arbol.insertarValor(8);
        arbol.insertarValor(4);

        // Mostrar el árbol horizontalmente
        arbol.mostrarHorizontal(0, arbol.getRaiz());

        // Recorrido en InOrden, PreOrden, PostOrden
        System.out.println("Recorrido en orden:");
        arbol.inOrden(arbol.getRaiz());
        System.out.println("\nRecorrido en preorden:");
        arbol.preOrden(arbol.getRaiz());
        System.out.println("\nRecorrido en postorden:");
        arbol.postOrden(arbol.getRaiz());
        
        // Buscar un valor en el árbol
        System.out.println("\nBuscar el valor 8 en el árbol:");
        int valor = 8;
        if(arbol.buscarNodo(valor, arbol.getRaiz())){
            
            System.out.println("\nEl valor " + valor + " fue encontrado en el árbol.");
            
        }
        else{

            System.out.println("\nEl valor " + valor + " no fue encontrado en el árbol.");
            
        }
        
        System.out.println("Eliminar el valor 8 del árbol:");
        // Eliminar un valor del árbol, en este caso, el valor 8
        arbol.eliminarValor(8);
        
        // Mostrar el árbol horizontalmente
        arbol.mostrarHorizontal(0, arbol.getRaiz());
        
    }
}
