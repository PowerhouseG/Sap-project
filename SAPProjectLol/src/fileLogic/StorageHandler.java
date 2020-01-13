/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileLogic;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import storeLogic.Product;

/**
 *
 * @author x
 */
public class StorageHandler {

    public void saveListOfProducts(List<Product> products) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("src/products.json").toFile(), products);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<Product> retrieveListOfProducts() {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products;
        try {
            products = Arrays.asList(mapper.readValue(Paths.get("src/products.json").toFile(), Product[].class));
            return products;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
