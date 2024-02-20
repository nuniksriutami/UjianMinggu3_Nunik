package com.juaracoding;

public class Utils {
    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    static void assertLogin(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Login berhasil");
        } else {
            System.out.println("Login Failed");
        }
    }
    static void assertAddCart(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Add to Cart berhasil");
        } else {
            System.out.println("Add to Cart Failed");
        }
    }
//    static void cartButton(){
//        if (assertAddCart.getText().equals("1")) {
//            System.out.println("Product added to cart successfully!");
//        } else {
//            System.out.println("Failed to add product to cart!");
//        }
//    } else {
//        System.out.println("Login failed!");
//    }
//    }
}
