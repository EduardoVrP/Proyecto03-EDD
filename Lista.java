import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Comparator;



public class Lista<T> {
    
   
    public Nodo<T> cabeza;
   
    public Nodo<T> rabo;
    
    private int longitud;

    /**
     * Regresa la longitud de la lista.
     * @return la longitud de la lista, el número de elementos que contiene.
     */
    public int getLongitud() {
	return longitud;
        // Aquí va su código.
    }

    /**
     * Nos dice si la lista es vacía.
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    public boolean esVacia() {
	if (cabeza == null)
	    return true;
	return false;
        // Aquí va su código.
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(T elemento) {
	if (elemento == null)
	    throw new IllegalArgumentException();
	Nodo<T> n = new Nodo<>(elemento);
	if (rabo == null){
	    cabeza = rabo = n;
	    longitud++;
	    return;
	}
	rabo.siguiente = n;
	n.anterior = rabo;
	rabo = n;
	longitud++;
        // Aquí va su código.
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaInicio(T elemento) {
	if (elemento == null)
	    throw new IllegalArgumentException();
        Nodo<T> n = new Nodo<>(elemento);
	if (cabeza == null){
	    cabeza = rabo = n;
	    longitud++;
	    return;
	}
	cabeza.anterior = n;
	n.siguiente = cabeza;
	cabeza = n;
	longitud++;
        // Aquí va su código.
    }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al fina de la misma. En otro caso,
     * después de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     * @param i el índice dónde insertar el elemento. Si es menor que 0 el
     *          elemento se agrega al inicio de la lista, y si es mayor o igual
     *          que el número de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void inserta(int i, T elemento) {
	if (elemento == null)
	    throw new IllegalArgumentException();
	Nodo<T> n = new Nodo<>(elemento);
	Nodo<T> aux = cabeza;
	if (i <= 0){
	    this.agregaInicio(n.elemento);
	    return;
	}
	if (i >= longitud){
	    this.agregaFinal(n.elemento);
	    return;
	}
	while (i != 0){
	    aux = aux.siguiente;
	    i--;
	}
	aux.anterior.siguiente = n;
	n.anterior = aux.anterior;
	aux.anterior = n;
	n.siguiente = aux;
	longitud++;
        // Aquí va su código.
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica.
     * @param elemento el elemento a eliminar.
     */
    public void elimina(T elemento) {
	if (elemento == null)
	    return;
	if (cabeza == null)
	    return;
	Nodo<T> aux = cabeza;
	while (!(aux.elemento.equals(elemento))){
	    if (aux == null)
		break;
	    aux = aux.siguiente;
	}
	if (cabeza == aux){
	    this.eliminaPrimero();
	    return;
	}
	if (rabo == aux){
	    this.eliminaUltimo();
	    return;
	    }
	if (aux != null){
	    aux.anterior.siguiente = aux.siguiente;
	    aux.siguiente.anterior = aux.anterior;
	    aux = null;
	    longitud--;
	    return;
	    }
	if(aux == null)
	    return;
        // Aquí va su código.
    }

    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object eliminaPrimero() {
	if (cabeza == null)
	    throw new NoSuchElementException();
	Object e = cabeza.elemento;
	if (cabeza == rabo){
	    cabeza = rabo = null;
	    longitud--;
	    return e;
	}else{
	cabeza = cabeza.siguiente;
	cabeza.anterior.siguiente = null;
	cabeza.anterior = null;
	longitud--;
	return e;
	}
        // Aquí va su código.
    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public Object eliminaUltimo() {
	if (cabeza == null)
	    throw new NoSuchElementException();
	Object e = rabo.elemento;
	if (rabo == cabeza){
	    cabeza = rabo = null;
	    longitud--;
	    return e;
	}else{
	rabo = rabo.anterior;
	rabo.siguiente.anterior = null;
	rabo.siguiente = null;
	longitud--;
	return e;
	}
        // Aquí va su código.
    }

    /**
     * Nos dice si un elemento está en la lista.
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <code>true</code> si <code>elemento</code> está en la lista,
     *         <code>false</code> en otro caso.
     */
    public boolean contiene(T elemento) {
	if(elemento == null)
	    return false;
	Nodo<T> aux = cabeza;
	while (aux != null){
	    if(aux.elemento.equals(elemento))
		return true;
	    aux = aux.siguiente;
	}
	return false;
        // Aquí va su código.
    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */
    public Lista reversa() {
	Lista reversa = new Lista();
	Nodo<T> aux = this.cabeza;
	while (aux != null){
	    reversa.agregaInicio(aux.elemento);
	    aux = aux.siguiente;
	}
    	return reversa;
        // Aquí va su código.
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */
    public Lista copia() {
	Lista copia = new Lista();
	Nodo<T> aux = this.cabeza;
	while (aux != null){
	    copia.agregaFinal(aux.elemento);
	    aux = aux.siguiente;
	}
	return copia;
    }

    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    public void limpia() {
	cabeza = null;
	rabo = null;
	longitud = 0;
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getPrimero() {
	if (cabeza == null)
	    throw new NoSuchElementException();
	return cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getUltimo() {
	if ( rabo == null)
	    throw new NoSuchElementException();
	return rabo.elemento;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista.
     * @throws ExcepcionIndiceInvalido si <em>i</em> es menor que cero o mayor o
     *         igual que el número de elementos en la lista.
     */
    public T get(int i) {
	if (i < 0)
	    throw new IndexOutOfBoundsException();
	if (i >= longitud)
	    throw new IndexOutOfBoundsException();
	Nodo<T> aux = cabeza;
	while ( i > 0){
	    aux = aux.siguiente;
	    i--;
	}
	return aux.elemento;
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */
    public int indiceDe(T elem) {
	int i = 0;
	Nodo<T> aux = cabeza;
	while (aux != null){
	    if (elem.equals((T)aux.get()))
		return i;
	    aux = aux.siguiente;
	    i++;
	}
	return -1;
    }

    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
    @Override public String toString() {
	if (cabeza == null)
	    return "[]";
	String s = "[";
	Nodo<T> aux = cabeza;
	while (aux != rabo){
	    s += String.format("%s, \n ", aux.elemento);
	    aux = aux.siguiente;
	}
	s += String.format("%s]", rabo.elemento);
	return s;
    }

    /**
     * Regresa el nodo cabeza de la lista.
     * @return el nodo cabeza de la lista.
     */
    public Nodo<T> getCabeza() {
	return cabeza;
        
    }

    /**
     * Regresa el nodo rabo de la lista.
     * @return el nodo rabo de la lista.
     */
    public Nodo<T> getRabo() {
	return rabo;
    }

 
}
