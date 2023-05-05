/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupplyChainClient;

import SupplyChainServer.Product;
import SupplyChainServer.SupplyChain;
import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.List;

/**
 *
 * @author nati
 */
public class SupplyChainClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Registry registry = LocateRegistry.getRegistry();
            System.out.println("client running ");
            Registry reg=  LocateRegistry.getRegistry("localhost",1888);
            SupplyChain stub = (SupplyChain)reg.lookup("SupplyChainServer");
            System.out.println("client running1 ");
            List<Product> products = stub.getProducts();
            System.out.println("Initial product list: " + products);

            Product p1 = new Product("Product 1", 10, 9.99);
            stub.addProduct(p1);
            products = stub.getProducts();
            System.out.println("Product list after adding a new product: " + products);

            p1.setPrice(14.99);
            stub.updateProduct(p1);
            products = stub.getProducts();
            System.out.println("Product list after updating the price of product 1: " + products);

            stub.removeProduct(p1);
            products = stub.getProducts();
            System.out.println("Product list after removing product 1: " + products);
        } catch (Exception e) {
            System.err.println("SupplyChainClient exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
