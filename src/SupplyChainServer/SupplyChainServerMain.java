/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupplyChainServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author nati
 */
public class SupplyChainServerMain {

    /**
     * @param args the command line arguments
     */
    private static boolean isExported = false;

    public static void main(String[] args) {
        try {
            SupplyChainServer supplyChainServer = new SupplyChainServer();

            Registry reg = LocateRegistry.createRegistry(3100);
            reg.rebind("SupplyChainServer", new SupplyChainServer());
//            SupplyChain stub;
//            synchronized (SupplyChainServerMain.class) {
//                if (isExported) {
//                    // Object has already been exported, use existing stub
//                    stub = (SupplyChain) Naming.lookup("rmi://localhost/SupplyChain");
//                } else {
//                    // Export the object and create a new stub
//                    stub = (SupplyChain) UnicastRemoteObject.exportObject(supplyChainServer, 0);
//                    Naming.rebind("rmi://localhost/SupplyChain", stub);
//                    isExported = true;
//                }
//            }

            System.out.println("SupplyChainServer is running...");
        } catch (Exception e) {
            System.err.println("SupplyChainServer exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
