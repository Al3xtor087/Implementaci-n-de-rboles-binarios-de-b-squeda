//Pérez Talavera Alejandro de Jesús


public class ABB{
    private Nodo raiz;
    // Constructor de la clase ABB
    ABB(){
        this.raiz = null;
    } 
    // Método para verificar si el árbol está vacío
    public boolean esVacio(){
        return (this.raiz == null); 
    }
    // Método para obtener la raíz del árbol
    public Nodo getRaiz(){
        return this.raiz;
    }
    // Método para insertar un valor en el árbol    
    public void insertarValor(int valor){
        if (this.raiz == null){
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        }
        else insertarNodo(valor, this.raiz);
    }
    // Método para insertar un nodo en el árbol
    public void insertarNodo(int valor, Nodo nodoRef){
        if (valor <= nodoRef.dato) {
            if (nodoRef.izquierdo == null){
                System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo =  new Nodo();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            }
            else {
                insertarNodo(valor, nodoRef.izquierdo);
            }
        }
        else {
            if (valor > nodoRef.dato) {
                if (nodoRef.derecho == null){
                    System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho =  new Nodo();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                }
                else {
                    insertarNodo(valor, nodoRef.derecho);
                }
            }
        }
    }
    // Método para mostrar el árbol de forma horizontal
    public void mostrarHorizontal(int nivel, Nodo nodoRef){
        if(nodoRef == null){
            return; 
        }
        else{

            mostrarHorizontal(nivel + 1, nodoRef.derecho);

            for(int i=0;i<nivel;i++){
                System.out.print("   ");
            }

            System.out.println("["+ nodoRef.dato + "]");
            mostrarHorizontal(nivel + 1, nodoRef.izquierdo);
        }
    }
    // Método para buscar un nodo en el árbol
    public boolean buscarNodo(int x, Nodo nodoRef){
        if (nodoRef==null)
            return false;
        else if(x<nodoRef.dato)
            return buscarNodo(x,nodoRef.izquierdo);
        else if(x>nodoRef.dato)
            return buscarNodo(x,nodoRef.derecho);
        else 
            return true; 
    }
    // Método para hacer un recorrido en preorden del árbol
    public void preOrden(Nodo nodoRef){
        if(nodoRef==null)
            return; 
        System.out.print(nodoRef.dato + " - ");
        preOrden(nodoRef.izquierdo);
        preOrden(nodoRef.derecho);
    }
    // Método para hacer un recorrido en inorden del árbol
    public void inOrden(Nodo nodoRef){
        if(nodoRef==null)
            return; 
        inOrden(nodoRef.izquierdo);
        System.out.print(nodoRef.dato + " - ");
        inOrden(nodoRef.derecho);
    }
    // Método para hacer un recorrido en postorden del árbol
    public void postOrden(Nodo nodoRef){
        if(nodoRef==null)
            return; 
        postOrden(nodoRef.izquierdo);
        postOrden(nodoRef.derecho);
        System.out.print(nodoRef.dato + " - ");
    }
    // Método para eliminar un valor del árbol
    public void eliminarValor(int valor) {
        raiz = eliminarNodo(raiz, valor);
    }
    // Método para eliminar un nodo del árbol
    private Nodo eliminarNodo(Nodo raiz, int valor) {
        if (raiz == null) {
            return raiz;
        }

        if (valor < raiz.dato) {
            raiz.izquierdo = eliminarNodo(raiz.izquierdo, valor);
        } else if (valor > raiz.dato) {
            raiz.derecho = eliminarNodo(raiz.derecho, valor);
        } else {
            if (raiz.izquierdo == null) {
                return raiz.derecho;
            } else if (raiz.derecho == null) {
                return raiz.izquierdo;
            }

            raiz.dato = minValor(raiz.derecho);

            raiz.derecho = eliminarNodo(raiz.derecho, raiz.dato);
        }

        return raiz;
    }
    // Método para encontrar el valor mínimo en el árbol
    private int minValor(Nodo raiz) {
        int minv = raiz.dato;
        while (raiz.izquierdo != null) {
            minv = raiz.izquierdo.dato;
            raiz = raiz.izquierdo;
        }
        return minv;
    }
}