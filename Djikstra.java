import java.util.PriorityQueue;

public class Djikstra{

    Lista<Vertice> vertices;
    Lista<Aristas> aristas;

    public Djikstra(Lista<Vertice> v, Lista<Aristas> a){
	this.vertices = v;
	this.aristas = a;
    }

    public Lista<Vertice> aplica(){
	PriorityQueue<Vertice> d = new PriorityQueue<>();
	Nodo auxV = vertices.getCabeza();
	Vertice inicial = (Vertice)auxV.get();
	Lista<Vertice> v = new Lista<>();
	Nodo auxA2 = aristas.getCabeza();
	//Ponemos valores a todos los vertices
	while( auxV != null){
	    ((Vertice)auxV.get()) .setValores(Double.POSITIVE_INFINITY, false, "");
	    auxV = auxV.siguiente;
	}
	 while(auxA2 != null){
		((Aristas)auxA2.get()).getVertice1().setValores(Double.POSITIVE_INFINITY, false, "");;
		((Aristas)auxA2.get()).getVertice2().setValores(Double.POSITIVE_INFINITY, false, "");;
		if(((Aristas)auxA2.get()).getVertice1().equals(inicial))
		    ((Aristas)auxA2.get()).getVertice1().setDistancia(0);
		if(((Aristas)auxA2.get()).getVertice2().equals(inicial))
		    ((Aristas)auxA2.get()).getVertice2().setDistancia(0);
		auxA2 = auxA2.siguiente;
	    }

	inicial.setDistancia(0);
	d.add(inicial);
	System.out.println(aristas);

	
	while (!d.isEmpty()){
	    System.out.println(d);
	    //extraer al minimo de la cola
	    Vertice u = d.remove();
	    u.setVisitado(true);
	    v.agregaFinal(u);
	    //comparar sus vecinos
	    Nodo auxA = aristas.getCabeza();
	    //iterar sobre las aristas
	    while(auxA != null){
		Vertice vertice1 = ((Aristas)auxA.get()).getVertice1();
		Vertice vertice2 = ((Aristas)auxA.get()).getVertice2();
		if (u.equals(vertice1)){
		    if (!vertice2.getVisitado()){
			if (vertice2.getDistancia() > u.getDistancia() + ((Aristas)auxA.get()).getPeso()){
			    vertice2.setDistancia(u.getDistancia() + ((Aristas)auxA.get()).getPeso());
			    vertice2.setPadre(u.getNombre());
			    d.add(vertice2);
			    auxA2 = aristas.getCabeza();
			    while(auxA2 != null){
				if(((Aristas)auxA2.get()).getVertice1().equals(vertice2)){
				    ((Aristas)auxA2.get()).getVertice1().setDistancia(vertice2.getDistancia());
				    ((Aristas)auxA2.get()).getVertice1().setPadre(vertice2.getPadre());
				    ((Aristas)auxA2.get()).getVertice1().setVisitado(vertice2.getVisitado());
				}
				if(((Aristas)auxA2.get()).getVertice2().equals(vertice2)){
				    ((Aristas)auxA2.get()).getVertice2().setDistancia(vertice2.getDistancia());
				    ((Aristas)auxA2.get()).getVertice2().setPadre(vertice2.getPadre());
				    ((Aristas)auxA2.get()).getVertice2().setVisitado(vertice2.getVisitado());
				}
				   
				auxA2 = auxA2.siguiente;
			    }
			}
		    }
		    
		}
		
		if (u.equals(vertice2)){
		    if (!vertice1.getVisitado()){
			if (vertice1.getDistancia() > u.getDistancia() + ((Aristas)auxA.get()).getPeso()){
			    vertice1.setDistancia(u.getDistancia() + ((Aristas)auxA.get()).getPeso());
			    vertice1.setPadre(u.getNombre());
			    d.add(vertice1);
			    auxA2 = aristas.getCabeza();
			    while(auxA2 != null){
				if(((Aristas)auxA2.get()).getVertice1().equals(vertice1)){
				    ((Aristas)auxA2.get()).getVertice1().setDistancia(vertice1.getDistancia());
				    ((Aristas)auxA2.get()).getVertice1().setPadre(vertice1.getPadre());
				    ((Aristas)auxA2.get()).getVertice1().setVisitado(vertice1.getVisitado());
				}
				if(((Aristas)auxA2.get()).getVertice2().equals(vertice1)){
				    ((Aristas)auxA2.get()).getVertice2().setDistancia(vertice1.getDistancia());
				    ((Aristas)auxA2.get()).getVertice2().setPadre(vertice1.getPadre());
				    ((Aristas)auxA2.get()).getVertice2().setVisitado(vertice1.getVisitado());
				}
				   
				auxA2 = auxA2.siguiente;
			    }
			    
			
			}
		    }
		    
		}
		auxA = auxA.siguiente;
	    }
	}
	return v;
    }
       

}
