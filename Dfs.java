import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Clase para hacer el DFS
 * 
 * @author Eduardo Vargas Perez, Ernesto Yahir Rivera Hernandez
 * @version junio 2022
 */
public class Dfs {
    //ATRIBUTOS
    //Un file con el cual trabajar
    public File doc;

    /**
     * Constructor, crea el objeto capaz de devolver el recorrido
     * 
     * @param doc El archivo con el que se va a trabajar
     */
    public Dfs(File doc){
        this.doc = doc;
    }

    /**
     * Metodo que lee los vertices del archivo, siempre y cuando no tengan grado 0
     * 
     * @return Una lista con los vertices
     * @throws FileNotFoundException
     */
    public Lista<Character> leeVertices() throws FileNotFoundException{
        Scanner obj = new Scanner(doc);
        Lista<Character> ver = new Lista<>();
        while(obj.hasNextLine()){
            String leido = obj.nextLine();
            String[] separacion = leido.split("-");
            ver.agregaFinal(separacion[0].charAt(0));
        }
        obj.close();
        return ver;
    }

    /**
     * Metodo que devuelve los vecinos de un vertice, siempre y cuando los tenga
     * 
     * @param v El vertive que se quieren conocer los vecinos
     * @param vertices Los vertices que no tienen grado 0
     * @return Una lista con los vecinos del vertice
     * @throws FileNotFoundException
     */
    public Lista<Character> leeVecinos(Character v, Lista<Character> vertices) throws FileNotFoundException{
        Lista<Character> vecinos = new Lista<>();
        Scanner obj = new Scanner(doc);
        if(vertices.contiene(v)){
            while(obj.hasNextLine()){
                String leido = obj.nextLine();
                if(v.equals(leido.charAt(0))){
                    String[] particion = leido.split("-");
                    for(int i = 0; i < particion[1].length();i++){
                        vecinos.agregaFinal(particion[1].charAt(i));
                    }
                }
            }
        }
        obj.close();
        return vecinos;
    }

    /**
     * Metodo que aplica DFS al archivo leido
     * 
     * 
     * @return Una lista con el recorrido
     */
    public Lista<Character> aplicaDFS(){
        try {
            Lista<Character> vertices = this.leeVertices();
            System.out.println("Vertices: " + vertices);
            Lista<Character> resultado = new Lista<>();
            Pila<Character> p = new Pila<>();

            //Empezamos algoritmo
            Character inicial = vertices.getPrimero();
            p.mete(inicial);
            while(!p.esVacia()){
                Character v = p.saca();
                resultado.agregaFinal(v);
                Lista<Character> vecinos = leeVecinos(v, vertices);
                System.out.println("Vecinos de " + v + ": " + vecinos);

                Nodo<Character> actual = vecinos.cabeza;
                //Metemos a la cola todos los vecnios de v que no esten ya encolados o visitados
                while(actual != null){
                    Character v2 = actual.elemento;
                    if(!p.contieneElemento(v2) && !resultado.contiene(v2)){
                        p.mete(actual.elemento);
                    }
                    actual = actual.siguiente;
                }
            }

            return resultado;

        } catch (Exception e) {
            return null;
        }
    }
}
