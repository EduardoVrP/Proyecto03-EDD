import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;
import java.util.Scanner;

/**
 * Clase menu que funcionara como el cliente del proyecto
 * 
 * @author Eduardo Vargas Perez, Ernesto Yahir Rivera Hernandez
 * @version junio 2022
 */
public class Menu{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
		int opcion=0;
		try {
			Socket cliente = new Socket("localhost", 4500);
			/***** ESCRIBIMOS ****/
			//Mensaje al servidor para ver que jale 
			DataOutputStream mensaje = new DataOutputStream(cliente.getOutputStream());
			mensaje.writeUTF("Activado");
			/*** LEEMOS ***/
			//Aqui el cliente lee el menu de operaciones
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			String mensaje2 = entrada.readUTF();
			System.out.println(mensaje2);
			/**** ESCRIBIMOS ****/		
			//seleccionamos la operacion deseada y decimos al servidor que opcion queremos
			opcion=teclado.nextInt();
			mensaje.writeInt(opcion);
			hazOperacion(opcion, cliente, mensaje);
			
		} catch(IOException ex) {
			Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
		} catch(Exception e){
            System.out.println("Ingresa lo solicitado");
        }
		teclado.close();
    }
    
    public static void hazOperacion(int opcion, Socket cliente, DataOutputStream mensaje) {
		Scanner teclado = new Scanner(System.in);
		try {
            System.out.println("La opcion actual es:" + opcion);
			if(opcion==4) {
				cliente.close();
                teclado.close();
				System.out.println("Conexion cerrada");
			} else {
                switch(opcion){
                    //Hacemos Djisktra
                    case 1:
                        
                        //VOLVEMOS A CARGAR DATOS	
                        /***** ESCRIBIMOS ****/
                        //Mandamos saludo al servidor
                        DataOutputStream mensajeNS = new DataOutputStream(cliente.getOutputStream());
                        mensajeNS.writeUTF("Hola servidor");
                
                        /*** LEEMOS ***/				
                        //Aqui el cliente lee el menu de operaciones
                        DataInputStream entradaNS = new DataInputStream(cliente.getInputStream());
                        String mensaje2NS = (String)entradaNS.readUTF();
                        System.out.println(mensaje2NS);
            
                        /**** ESCRIBIMOS ****/		
                        //seleccionamos la operacion deseada y decimos al servidor que opcion queremos
                        int op=teclado.nextInt();
                        mensaje.writeInt(op);

                        hazOperacion(op, cliente, mensajeNS);
                    break;
                    //Hacemos BFS
                    case 2:

                        //VOLVEMOS A CARGAR DATOS	
                        /***** ESCRIBIMOS ****/
                        //Mandamos saludo al servidor
                        DataOutputStream mensajeNR = new DataOutputStream(cliente.getOutputStream());
                        mensajeNR.writeUTF("Hola servidor");
                
                        /*** LEEMOS ***/				
                        //Aqui el cliente lee el menu de operaciones
                        DataInputStream entradaNR = new DataInputStream(cliente.getInputStream());
                        String mensaje2NR = (String)entradaNR.readUTF();
                        System.out.println(mensaje2NR);
            
                        /**** ESCRIBIMOS ****/		
                        //seleccionamos la operacion deseada y decimos al servidor que opcion queremos
                        int op2=teclado.nextInt();
                        mensajeNR.writeInt(op2);
                        hazOperacion(op2, cliente, mensajeNR);
                        break;
                    //Hacemos DFS
                    case 3:
                        
                        //VOLVEMOS A CARGAR DATOS	
                        /***** ESCRIBIMOS ****/
                        //Mandamos saludo al servidor
                        DataOutputStream mensajeNM = new DataOutputStream(cliente.getOutputStream());
                        mensajeNM.writeUTF("Hola servidor");
                
                        /*** LEEMOS ***/				
                        //Aqui el cliente lee el menu de operaciones
                        DataInputStream entradaNM = new DataInputStream(cliente.getInputStream());
                        String mensaje2NM = (String)entradaNM.readUTF();
                        System.out.println(mensaje2NM);
            
                        /**** ESCRIBIMOS ****/		
                        //seleccionamos la operacion deseada y decimos al servidor que opcion queremos
                        int op3=teclado.nextInt();
                        mensajeNM.writeInt(op3);
                        hazOperacion(op3, cliente, mensajeNM);
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        //VOLVEMOS A CARGAR DATOS	
                        /***** ESCRIBIMOS ****/
                        //Mandamos saludo al servidor
                        DataOutputStream mensajeNDef = new DataOutputStream(cliente.getOutputStream());
                        mensajeNDef.writeUTF("Hola servidor");
                
                        /*** LEEMOS ***/				
                        //Aqui el cliente lee el menu de operaciones
                        DataInputStream entradaNDef = new DataInputStream(cliente.getInputStream());
                        String mensaje2NDef = (String)entradaNDef.readUTF();
                        System.out.println(mensaje2NDef);
            
                        /**** ESCRIBIMOS ****/		
                        //seleccionamos la operacion deseada y decimos al servidor que opcion queremos
                        int opD=teclado.nextInt();
                        mensajeNDef.writeInt(opD);
                        hazOperacion(opD, cliente, mensajeNDef);
                        break;
                }
			}
				
		} catch(IOException ex) {
			Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
		} 	
	}

    
}