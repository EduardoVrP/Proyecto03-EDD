public class Nodo<T> {

    
        T elemento;
        
        Nodo anterior;
        
        Nodo siguiente;


	

        public Nodo(T elemento) {
	    this.elemento = elemento;
            // Aquí va su código.
        }

        public Nodo<T> getAnterior() {
	    return anterior;
            // Aquí va su código.
        }

        public Nodo<T> getSiguiente() {
	    return siguiente;
            // Aquí va su código.
        }

        public T get() {
	    return elemento;
            
        }
    }
