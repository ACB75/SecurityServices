package securityservices.checkdata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	0 correcte
  	-1 no acompleix amb el patro
  	-2 el resultat no es correcte
*/
public class Check {

	protected static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	 public static String readOperation(int error) {
     	
		 String errorData = "";
		 
	      switch (error) {
	          case 0:
	        	  errorData = "Operacion Correcta";
	        	  break;
	        	  
	          case -1:
	        	  errorData = "Cadena Mal Formada";
	        	  break;
	        	  
	          case -2:
	        	  errorData = "Operacion Incorrecta";
	        	  break;
	      }
	      
	      return errorData;
     }
	 
    public static int checkExample(String request) {
    	
        int valor1, valor2, result;
        String signo;
        Pattern pattern = Pattern.compile("(\\d+)([+-/*])(\\d+)\\=(\\d+)$");
        Matcher matcher = pattern.matcher(request);

        if (matcher.matches()) {
            //System.out.println("Primer valor numeric = " + matcher.group(1));
            //System.out.println("Segon valor numeric = " + matcher.group(3));
            //System.out.println("Resultat numeric = " + matcher.group(4));
            valor1 = Integer.valueOf(matcher.group(1));
            signo = matcher.group(2);
            valor2 = Integer.valueOf(matcher.group(3));
            result = Integer.valueOf(matcher.group(4));
            switch (signo) {
                case "+":
                    if (valor1 + valor2 == result) {
                        return 0;
                    }
                    break;
                case "-":
                    if (valor1 - valor2 == result) {
                        return 0;
                    }
                    break;
                case "*":
                    if (valor1 * valor2 == result) {
                        return 0;
                    }
                    break;
                case "/":
                    if (valor1 / valor2 == result) {
                        return 0;
                    }
                    break;
            }
        } else {
            return -1;
        }
        return -2;
    }
    
    public static int checkDNI(String data) {
    	
     	Pattern pattern = Pattern.compile("([X])?(\\d{7,8})[ -]?([TRWAGMYFPDXBNJZSQVHLCKE])$", Pattern.CASE_INSENSITIVE);   	
    	Matcher matcher = pattern.matcher(data);
    	String[] dniChar = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
    	
    	if (data != null && matcher.matches()){
    		
    		int position;
    		int number = Integer.valueOf(matcher.group(2));
    		Character letter = matcher.group(3).toUpperCase().charAt(0);

    		do  {
    			
    			position = calcMod(number, 23);
    		}
    			while (position > 23);
    		
    		if (!dniChar[position].equals(Character.toString(letter))) return -2;
    	}
    	
    	else return -1;
    	
    	return 0;
    }
    
    public static int checkDates (String data){
        
    	//dd/mm/yyyy
        Pattern pattern = Pattern.compile("(\\d{1,2})[-/](\\d{1,2})[-/](\\d{4})$");
        Matcher matcher = pattern.matcher(data);
        
        if (matcher.matches()){
        	
        	int day =Integer.valueOf(matcher.group(1));
        	int month =Integer.valueOf(matcher.group(2));
        	int year=Integer.valueOf(matcher.group(3));
        	
        	if (monthOk(month) && dayOk(day, month)) return 0;
        	else if (isLeap(year) && month == 2 && day == 29) return 0;
        	else return -2;
        }
        	else return -1;
    }
    
    public static int diffData(String dateMin, String dateMax) {
        
        int daysMin = 0, daysMax = 0, i, monthMin, monthMax, yearMin, yearMax;
        // dd/mm/yyyy
        Pattern patro = Pattern.compile("(\\d{1,2})[-/](\\d{1,2})[-/](\\d{4})$");
        Matcher matcherDateMin, matcherDateMax;
       
        if (checkDates(dateMin) != 0 || checkDates(dateMax) != 0) {
        	
            return -1;
        }
        
        matcherDateMin = patro.matcher(dateMin);
        matcherDateMax = patro.matcher(dateMax); 
        
        matcherDateMin.matches();
        matcherDateMax.matches();                
        
        monthMin = Integer.valueOf(matcherDateMin.group(2));
        monthMax = Integer.valueOf(matcherDateMax.group(2));
        yearMin = Integer.valueOf(matcherDateMin.group(3));
        yearMax = Integer.valueOf(matcherDateMax.group(3));      
        daysMin += Integer.valueOf(matcherDateMin.group(1));
        daysMax += Integer.valueOf(matcherDateMax.group(1));
        
        for (i = 0; i < monthMin - 1; i++) {
        	
            daysMin += daysInMonth[i];
        }
        
        if (monthMin > 2 && isLeap(yearMin)) {
            daysMin += 1;
        }
        
        for (i = 0; i < monthMax - 1; i++) {
        
        	daysMax += daysInMonth[i];
        }
        
        if (monthMax > 2 && isLeap(yearMax)) {
            
        	daysMax += 1;
        }
        
        for (i = yearMin; i < yearMax; i++) {
        	
        	daysMax += 365;           
            
        	if (isLeap(i)) {
            
        		daysMax += 1;
            }
        }
        
        return daysMax - daysMin;
    }
    
    public static int checkEmail (String data){
    	//Doble punto TODO
        Pattern pattern = Pattern.compile("([0-9a-zA-Z._%-+]{2,64})[@]([0-9a-zA-Z.-]{2,64})[.]{1}([a-zA-Z]{2,6})$");
        Matcher myMatch = pattern.matcher(data);
        
        if(myMatch.matches()) return 0;
        
        else return -1;
    }
    
    public static int calcMod(Integer number, Integer mod) {
    	
    	return number % mod;
    }

    private static boolean isLeap(int year) {
    	
    	if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) return true;
    	
    	else return false;
    }  
    
    private static boolean monthOk(int month) {
    	
    	if(month > 0 && month < 13 ) return true;
    	
    	else return false;
    } 
    
    private static boolean dayOk(int day, int month) {
    	
    	if(day > 0 && day <= daysInMonth[month-1]) return true;
    	
    	else return false;
    }
}