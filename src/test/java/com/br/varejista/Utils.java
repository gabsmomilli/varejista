package com.br.varejista;

import com.br.varejista.model.Client;
import com.br.varejista.model.Product;
import com.br.varejista.model.ShoppingBag;
import com.br.varejista.model.Storage;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class Utils {

    public Client makeClient(){
        return new Client(1,"Gabi","1234567890","129813245","gabsmomilli@gmail.com", LocalDate.now(), "F");
    }

    public Product makeProduct(){
        return new Product(1,"Scarpin","Material sem origem animal", 300.0, 36,
                1, "Preto", "Salto", "Arezzo",
                LocalDate.of(2024, 1, 23));
    }

    public Set<Product> makeProducts(){
        Set<Product> products = new HashSet<>();
        products.add(makeProduct());
        return products;
    }

    public Storage makeStorage(Set<Product> products){
        return new Storage(1,products ,"Oscar SJC", "12345678910", "Grupo Oscar", "Rua Central, 123");
    }

    public ShoppingBag makeShoppingBag(Set<Product> products){
        return new ShoppingBag(1, products, makeClient(), 100.0, 0.0);
    }
}
