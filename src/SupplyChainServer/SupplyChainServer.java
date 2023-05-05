/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupplyChainServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nati
 */
public class SupplyChainServer extends UnicastRemoteObject implements SupplyChain {

    private List<Product> products = new ArrayList<Product>();

    public SupplyChainServer() throws RemoteException {
        super();
    }

    public List<Product> getProducts() throws RemoteException {
        return products;
    }

    public void addProduct(Product p) throws RemoteException {
        products.add(p);
    }

    public void removeProduct(Product p) throws RemoteException {
        products.remove(p);
    }

    public void updateProduct(Product p) throws RemoteException {
        int index = products.indexOf(p);
        if (index != -1) {
            products.set(index, p);
        }
    }
}
