import java.net.ServerSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		try {
		
			ServerSocket servidor = new ServerSocket(4500);
			Socket clienteNuevo = servidor.accept();

			System.out.println("Se ha establecido la conexion");
	
			/***** LEEMOS ***/
			//Esto lo lee el servidor, en esta caso se lee el saludo
			DataInputStream entrada = new DataInputStream(clienteNuevo.getInputStream());
			String mensaje = (String)entrada.readUTF();
			System.out.println("Este es el mensaje del cliente: " + mensaje);

			/**** ESCRIBIMOS ****/
			//Le mostramos al cliente las operaciones que puede hacer
			DataOutputStream respuesta = new DataOutputStream(clienteNuevo.getOutputStream());
			String menucito = mostrarMenu();
			respuesta.writeUTF(menucito);	
						
			/**** LEEEMOS *****/	
			//Leemos la opcion de la operacion que quiere hacer el usuario	
			int operacionDeseada = entrada.readInt();
			System.out.println("Esto es lo que quiere el cliente: " + operacionDeseada);

			solicitaOperacion(operacionDeseada, clienteNuevo, servidor, entrada);

		}  catch(IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static String mostrarMenu() {
		return "Servidor: \nTeclea una opcion:\n1. Djikstra\n2. BFS\n3. DFS\n4. Salir";
	}

    public static void solicitaOperacion(int op, Socket cn, ServerSocket serv, DataInputStream entrada) {
		try {
			if(op==4) {	
				serv.close();	
			} else {
				//Hacemos una suma
				if(op==1) {		

					//VOLVEMOS A CARGAR DATOS
					/***** LEEMOS ***/
					//Esto lo lee el servidor, en esta caso se lee el saludo
					DataInputStream entradaNS = new DataInputStream(cn.getInputStream());
					String mensajeNS = entradaNS.readUTF();
					System.out.println("Este es el mensaje del cliente: " + mensajeNS);

					/**** ESCRIBIMOS ****/
					//Le mostramos al cliente las operaciones que puede hacer
					DataOutputStream respuestaNS = new DataOutputStream(cn.getOutputStream());
					String menucitoNS = mostrarMenu();
					respuestaNS.writeUTF(menucitoNS);	
					
					/**** LEEEMOS *****/	
					//Leemos la opcion de la operacion que quiere hacer el usuario	
					int operacionDeseadaNS = entrada.readInt();
					System.out.println("Esto es lo que quiere el cliente: " + operacionDeseadaNS);

					solicitaOperacion(operacionDeseadaNS, cn, serv, entrada);				
				}// termina op==1

				//Es una resta
				if(op==2) {			

					//VOLVEMOS A CARGAR DATOS
					/***** LEEMOS ***/
					//Esto lo lee el servidor, en esta caso se lee el saludo
					DataInputStream entradaNR = new DataInputStream(cn.getInputStream());
					String mensajeNR = entradaNR.readUTF();
					System.out.println("Este es el mensaje del cliente: " + mensajeNR);
	
					/**** ESCRIBIMOS ****/
					//Le mostramos al cliente las operaciones que puede hacer
					DataOutputStream respuestaNR = new DataOutputStream(cn.getOutputStream());
					String menucitoNR = mostrarMenu();
					respuestaNR.writeUTF(menucitoNR);	
					
					/**** LEEEMOS *****/	
					//Leemos la opcion de la operacion que quiere hacer el usuario	
					int operacionDeseadaNR = entrada.readInt();
					System.out.println("Esto es lo que quiere el cliente: " + operacionDeseadaNR);

					solicitaOperacion(operacionDeseadaNR, cn, serv, entrada);
				}
				// es una multiplicaci√≥n
				if(op==3) {			
			
					/**** ESCRIBIMOS *****/
					//Le decimos al cliente la respuesta
					DataOutputStream respuestaMultiplicacion = new DataOutputStream(cn.getOutputStream());
					respuestaMultiplicacion.writeUTF("Opcion DFS");

					//VOLVEMOS A CARGAR DATOS
					/***** LEEMOS ***/
					//Esto lo lee el servidor, en esta caso se lee el saludo
					DataInputStream entradaND = new DataInputStream(cn.getInputStream());
					String mensajeND = (String)entradaND.readUTF();
					System.out.println("Este es el mensaje del cliente: " + mensajeND);

					/**** ESCRIBIMOS ****/
					//Le mostramos al cliente las operaciones que puede hacer
					DataOutputStream respuestaND = new DataOutputStream(cn.getOutputStream());
					String menucitoND = mostrarMenu();
					respuestaND.writeUTF(menucitoND);	
					
					/**** LEEEMOS *****/	
					//Leemos la opcion de la operacion que quiere hacer el usuario	
					int operacionDeseadaND = entrada.readInt();
					System.out.println("Esto es lo que quiere el cliente: " + operacionDeseadaND);

					solicitaOperacion(operacionDeseadaND, cn, serv, entrada);
				}
			}
		/*} catch(ClassNotFoundException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);*/
		} catch(IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}//termina solicitaOp
}
