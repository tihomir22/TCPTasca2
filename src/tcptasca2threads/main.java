/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcptasca2threads;

/**
 *
 * @author sportak
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor server = new Servidor();
        Cliente cli = new Cliente();

        server.start();
        cli.start();
    }

}
