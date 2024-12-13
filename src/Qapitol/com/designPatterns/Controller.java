package Qapitol.com.designPatterns;

import Qapitol.com.designPatterns.ProductFactory;

public class Controller {

    public static void main(String[] args) {

//		SingleTonDesign design  = SingleTonDesign.getInstance();
//		SingleTonDesign design1  = SingleTonDesign.getInstance();
//
//		if(design.equals(design1) ) {
//			System.out.println(" Objects are same");
//		}else {
//			System.out.println("Objects are diffrent");
//		}


        ProductFactory productFactory = new ProductFactory("Product2");
        Product product = (Product) productFactory.instanceFactory();
        product.make();

    }

}
