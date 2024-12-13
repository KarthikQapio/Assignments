package Qapitol.com.designPatterns;

import Qapitol.com.designPatterns.Product1;
import Qapitol.com.designPatterns.Product3;
//import Qapitol.com.design_pattern.Product;
//import Qapitol.com.design_pattern.Product2;

public class ProductFactory {

    private String name;

    public ProductFactory(String name){
        this.name = name;
    }


    public Product instanceFactory() {

        if(name.equalsIgnoreCase("Product1")) {
            return (Product) new Product1();
        }else if(name.equalsIgnoreCase("Product2")) {
            return (Product) new Product2();
        }else if(name.equalsIgnoreCase("Product3")) {
            return (Product) new Product3();
        }
        return null;
    }

}
