/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcptasca2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sportak
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        String mensaje = "100";
        Scanner teclado = new Scanner(System.in);

        //puerto de nuestro servidor
        final int PUERTO = 5000;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);
            System.out.println("[SERVIDOR] " + "Servidor iniciado");

            //Siempre estara escuchando peticiones
            //Espero a que un cliente se conecte
            sc = servidor.accept();

            System.out.println("[SERVIDOR] " + "Cliente conectado");
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            while (!mensaje.equalsIgnoreCase("adeu")) {

                //Leo el mensaje que me envia
                mensaje = in.readUTF();

                System.out.println("[SERVIDOR] He recibido del cliente" + mensaje);

                //Le envio un mensaje
                out.writeUTF(teclado.nextLine());

            }
            System.out.println("[SERVIDOR] " + "Servidor desconectado");
            //Cierro el socket
            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
