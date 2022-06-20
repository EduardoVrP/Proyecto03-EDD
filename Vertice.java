public class Vertice implements Comparable<Vertice>{

    String nombre;
    double distancia;
    boolean visitado;
    String padre;

    public Vertice(String nombre){
	this.nombre = nombre.trim();
	distancia = 0;
	visitado = false;
	padre = "";
    }

    public void setValores(double distancia, boolean visitado, String padre){
	this.distancia = distancia;
	this.visitado = visitado;
	this.padre = padre;
    }

    public void setDistancia(double distancia){
	this.distancia = distancia;
    }

    public double getDistancia(){
	return distancia;
    }

    public void setVisitado(boolean v){
	this.visitado = v;
    }

    public boolean getVisitado(){
	return visitado;
    }

    public void setPadre(String padre){
	this.padre = padre;
    }

    public String getPadre(){
	return padre;
    }

    public String getNombre(){
	return nombre;
    }

    
    @Override public int compareTo(Vertice a){
	if(this.getDistancia() > a.getDistancia())
	    return 1;
	if(this.getDistancia() < a.getDistancia())
	    return -1;
	return 0;
    }

    public boolean equals(Vertice a){
	if (a == null)
	    return false; 
	if (this.nombre.equals(a.getNombre()))
	    return true;
	return false;
    }

    public String toString(){
	return nombre + " distancia = " + distancia + " Padre = " + padre;
    }
	
}
	
