public class Aristas implements Comparable<Aristas>{
    Vertice n1;
    Vertice n2;
    int peso;

    public Aristas(Vertice n1, Vertice n2, int p){
	this.n1 = n1;
	this.n2 = n2;
	peso = p;
    }

   public Aristas(){
    }

    public void tomaValores(Vertice n1, Vertice n2, int p){
	this.n1 = n1;
	this.n2 = n2;
	this.peso = p;
    }

    public int getPeso(){
	return this.peso;
    }

    public Vertice getVertice1(){
	return n1;
    }

    public Vertice getVertice2(){
	return n2;
    }


    @Override public String toString(){
	return this.n1.getNombre() + " " + this.n2.getNombre() + " " + peso;
	
    }
    
    @Override public int compareTo(Aristas a){
	if(this.getPeso() > a.getPeso())
	    return 1;
	if(this.getPeso() < a.getPeso())
	    return -1;
	return 0;
    }

    public boolean equals(Aristas a){
	if (n1.equals(a.getVertice1()) && n2.equals(a.getVertice2()))
	    return true;
	if (n1.equals(a.getVertice2()) && n2.equals(a.getVertice1()))
	    return true;
	return false;
    }
    
}
