/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcptasca2threads;

import tcptasca2.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sportak
 */
public class Cliente extends Thread {

    /**
     * @param args the command line arguments
     */
    //Host del servidor
    final String HOST = "localhost";
    Scanner teclado = new Scanner(System.in);
    String mensaje = " ";
    //Puerto del servidor
    final int PUERTO = 5000;
    DataInputStream in;
    DataOutputStream out;

    public void run() {
        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(InetAddress.getByName(HOST), PUERTO);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            while (!mensaje.equalsIgnoreCase("adeu")) {
                //Envio un mensaje al cliente
                System.out.println("[CLIENTE] " + "Voy a enviar lo siguiente que escriba al servidor");
                mensaje = teclado.nextLine();
                out.writeUTF(mensaje);
                if (mensaje.equalsIgnoreCase("adeu")) {
                    break;
                }
                //Recibo el mensaje del servidor
                mensaje = in.readUTF();

                System.out.println("[CLIENTE] Recibido " + mensaje);

                out.flush();
            }

            System.out.println("[CLIENTE] " + "Cliente desconectado");
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
