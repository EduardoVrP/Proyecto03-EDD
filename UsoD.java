import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
public class UsoD{



    public static Lista<Vertice> leeDjikstraV(String nombreArchivo){
	Lista<Vertice> vertices = new Lista<>();
	try {
            FileInputStream fileIn = new FileInputStream(nombreArchivo);
            InputStreamReader isIn = new InputStreamReader(fileIn);
            BufferedReader in = new BufferedReader(isIn);
	    String linea = in.readLine();
	    while (linea != null && !linea.trim().equals("")){
		if(linea.length() == 1){
		    Vertice v = new Vertice(linea);
		    vertices.agregaFinal(v);
		}
		linea = in.readLine();
	    }
            in.close();
	    return vertices;
	}catch (IOException ioe) {
            System.out.printf("No pude cargar del archivo \"%s\".\n",
                              nombreArchivo);
            System.exit(1);
	}
	return vertices;
    }

     public static Lista<Aristas> leeDjikstraA(String nombreArchivo){
	Lista<Aristas> aristas = new Lista<>();
	try {
            FileInputStream fileIn = new FileInputStream(nombreArchivo);
            InputStreamReader isIn = new InputStreamReader(fileIn);
            BufferedReader in = new BufferedReader(isIn);
	    String linea = in.readLine();
	    while (linea != null && !linea.trim().equals("")){
		if (linea.length() > 1){		   
		    linea.strip();
		    String[]aristaYp = linea.split(" ");
		    Vertice n1 = new Vertice(aristaYp[0]);
		    Vertice n2 = new Vertice(aristaYp[1]);		   
		    int peso = Integer.parseInt(aristaYp[2]);
		    Aristas arista = new Aristas(n1, n2, peso);
		    aristas.agregaFinal(arista);
		}
		linea = in.readLine();
	    }
            in.close();
	    return aristas;
	}catch (IOException ioe) {
            System.out.printf("No pude cargar del archivo \"%s\".\n",
                              nombreArchivo);
            System.exit(1);
	}
	return aristas;
    }
    
    public static void main(String[] args){
	Lista<Vertice> vertices = leeDjikstraV("Djikstra.txt");
	Lista<Aristas> aristas = leeDjikstraA("Djikstra.txt");
	Djikstra dj = new Djikstra(vertices, aristas);
	Lista<Vertice> resultado = dj.aplica();
	System.out.println(resultado);
    }
}
