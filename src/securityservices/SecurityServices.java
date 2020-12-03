package securityservices;

import java.util.HashMap;

import securityservices.checkdata.Check;
import securityservices.operations.Order;
import securityservices.operations.Stock;

public class SecurityServices {

    public static void main(String[] args) {
    	/*
    	//ACT 4 EXPRESIONES REGULARES
        int error = Check.checkExample("4500-2570=1930");
        String errorData = Check.readOperation(error);
        System.out.println("checkExample: " + errorData);
        
        error = Check.checkExample("45/5=9");
        errorData = Check.readOperation(error);
        System.out.println("checkExample: " + errorData);
     
        //error = 0
        error = Check.checkDNI("6236515-L");
        errorData = Check.readOperation(error);
        System.out.println("checkDNI: " + errorData);	
        //error = -1
        error = Check.checkDNI("X6236515L");
        errorData = Check.readOperation(error);
        System.out.println("checkDNI: " + errorData);	
        //error = -2
        error = Check.checkDNI("X6236515M");
        errorData = Check.readOperation(error);
        System.out.println("checkDNI: " + errorData);      
        //error = 0
        error = Check.checkDates("12-09-2019");
        errorData = Check.readOperation(error);
        System.out.println("checkDates: " + errorData);    
        //error = -1
        error = Check.checkDates("29/2/2021");
        errorData = Check.readOperation(error);
        System.out.println("checkDates: " + errorData);   
        //error = -2
        error = Check.checkDates("88/s3/2020");
        errorData = Check.readOperation(error);
        System.out.println("checkDates: " + errorData); 
        //error = 0
        error = Check.diffData("12/09/2019", "13/09/2019");
        System.out.println("diffData: " + error);     
        //error = -1
        error = Check.diffData("29/02/2020", "28/02/2021");
        System.out.println("diffData: " + error);    
        //error = -2
        error = Check.diffData("31/02/2019", "11/09/2020");
        errorData = Check.readOperation(error);
        System.out.println("diffData: " + errorData);  
        //error = 0
        error = Check.checkEmail("alexiscesco99@gmail.com");
        errorData = Check.readOperation(error);
        System.out.println("checkEmail: " + errorData);
        //error = -1
        error = Check.checkEmail("alexiscesco99gmail.com");
        errorData = Check.readOperation(error);
        System.out.println("checkEmail: " + errorData);     
        //error = -1
        error = Check.checkEmail("alexiscesco99@gmail.com.");
        errorData = Check.readOperation(error);
        System.out.println("checkEmail: " + errorData);
        */
    	
    	//ACT 5 LISTAS DINÁMICAS
        Order detail = new Order();
        
        detail.setDetail("1;10;00REF");
        int error = detail.setDetail("1;20;00REF");
        System.out.println ("No repeated details: " + error);
        detail.setDetail("5;10;01REF");
        detail.setDetail("9;10;02REF");
        
        for (int i = 0; i < detail.getNumDetails(); i++) {
        	
        	System.out.println ("getDetail by Int: " + detail.getDetail(i));
        }
        
        System.out.println ("getDetail by String: " + detail.getDetail("02REF"));
        
        detail.updateDetail(0, "1;30.00;REF00");
        System.out.println ("getDetail by Int: " + detail.getDetail(0));
        
        detail.updateDetail("01REF", "8;40.00;REF01");
        System.out.println ("getDetail by String: " + detail.getDetail("REF01"));
        
        error = detail.deleteDetail(0);
        error = detail.deleteDetail("REF01");
        System.out.println ("getDetail by String: " + error + detail.getDetail("00REF"));
        System.out.println ("getDetail by String: " + error +  detail.getDetail("01REF"));
        
        error = detail.setDetail(";;;");
        System.out.println ("Expected error: " + error);
        error = detail.setDetail("0;1.00;REF09;");
        System.out.println ("Expected error: " + error);
        error = detail.setDetail("1;0.00;REF09;");
        System.out.println ("Expected error: " + error);
        
        double valorTotal = detail.getValue();
        System.out.println ("Valor total: " + valorTotal);
        
        Stock stock = new Stock();
        HashMap <String, Integer> inventory = new HashMap <String, Integer>();
        
        inventory.put("Casa", 1);
        inventory.put("Piso", 5);
        inventory.put("Apartamento", 7); 
        stock.setStock(inventory);
        
        error = stock.updateStock("Casa", 2);
        System.out.println(error + " OK");
        error = stock.updateStock("Apartamento", -3);
        System.out.println(error + " OK");
        error = stock.updateStock("Piso", -6);
        System.out.println (error + " KO, no negative result");
        
        stock.delFromStock("Casa");
        System.out.println(stock.getStock());
        
        System.out.println("GetAmount: " + stock.getAmount("Piso"));
        System.out.println("totalNumLines from getNumLines " + stock.getNumLines());
        
        String[] linesFromStock = stock.getLines();
        
        for (int i = 0; i < linesFromStock.length; i++) {
        	
        	System.out.println ("getLines: " + linesFromStock[i]);
        }
    }
}
