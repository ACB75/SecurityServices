package securityservices.operations;

import java.util.HashMap;

public class Stock {

	protected HashMap<String, Integer> stock;
	protected String storePlace;
	
	public HashMap<String, Integer> getStock() {
		
		return stock;
	}

	public void setStock(HashMap<String, Integer> stock) {
		
		this.stock = stock;
	}

	public int updateStock (String key, int amount ) {
		
        int result = 0;
        if(checkKey(key) && findKey(key) && amount != 0) {

        	
        	if (!negativeValue(amount)){ //Suma

        		stock.replace(key, stock.get(key) + amount);
	        }
        	
		        else if(negativeValue(stock.get(key) + amount)==false){ //Resta
		        	
		        	stock.replace(key, amount + stock.get(key));
		            result = stock.get(key);
		        }
		        	else return -2;
        }
        	else return -1;
        
        return result;        
    }
    
    public int getAmount (String key) {
    	
        int result;
        
        if (findKey(key)) result = stock.get(key);
        else result = -1;        
        
        return result;      
    }
    
    public int delFromStock (String key) {
    
        int result = 0;
       
        if (findKey(key)) stock.remove(key);
        else result = -1;
        
        return result;       
    }
    
    public String[] getLines () {
    	
        String conversion = stock.entrySet().toString();
        
        conversion = conversion.replace("[", "");
        conversion = conversion.replace("]", ",");
        
        String[] result = conversion.split(",");
        
        return result;      
    }
    
    public int getNumLines() {
    	
        return stock.size();
    }
    
    private boolean checkKey(String key) {
    	
    	if (key != null && key.trim().length() > 0) return true;
    	else return false;
    }
    
    private boolean findKey(String key) {
    	
    	if (stock.containsKey(key)) return true;
    	else return false;
    }
    
    private boolean negativeValue(int n) {
    	
    	if (n < 0) return true;
    	else return false;
    }
}