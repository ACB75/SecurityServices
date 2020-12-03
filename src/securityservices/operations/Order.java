package securityservices.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Order extends Operation implements Billable {

    protected String paymentType;
    protected LocalDateTime paymentDate;
    protected ArrayList<OrderDetail> details = new ArrayList();

    public Order() {
    }

    public Order(String code, int creator, double value, double surcharges, String type,
            String status, String additonalInfo, String beginDate, String finishDate,
            String paymentType, String paymentDate) {
        super(code, creator, value, surcharges, type, status, additonalInfo, beginDate, finishDate);
        this.paymentType = paymentType;
        this.setPaymentDate(paymentDate);
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentDate() {
        if (this.paymentDate != null) {
            return this.paymentDate.format(this.dateTimeFormatter);
        }
        return "";
    }

    public void setPaymentDate(String paymentDate) throws DateTimeParseException {
        if (paymentDate != null && paymentDate.trim().length() > 0) {
            this.paymentDate = LocalDateTime.parse(paymentDate, this.dateTimeFormatter);
        }
    }

    @Override
	public int getNumDetails() {
		
		return details.size();
	}

	@Override
	public int setDetail(String detail) {
		
		if (noNull(detail)) {
			
			String[] splitedDetail = detail.split(";");
			
			if(splitedDetail.length == 3) {
				
				OrderDetail od = new OrderDetail();
				String detailToUpdate = getDetail(splitedDetail[2]);
				Integer amount = Integer.parseInt(splitedDetail[0]);
				
				if(amount == 0) return -3;
				
				if(detailToUpdate != "") {
					
					String[] splitedDetailExistent = detailToUpdate.split(";");

					updateDetail(splitedDetailExistent[0], detail);
					
					return 0;
				}
					
				Double price = Double.parseDouble(splitedDetail[1]);

				if(price != 0.0) od.setPrice(price); else return -3;

				od.setRef(splitedDetail[2]);								
				od.setAmount(amount);
				
				details.add(od);
				
				return 0;
			}
			
			else return -2;			
		}
		
		else return -1;
	}

	@Override
	public String getDetail(int n) {
			
		if (n == 0) n += 1;
			
		String ref = details.get(n-1).getRef();
		String amount = Integer.toString(details.get(n-1).getAmount());
		String price = Double.toString(details.get(n-1).getPrice());
		
		return ref+";"+amount+";"+price;		
	}

	@Override
	public String getDetail(String n) {

	    String result = "";
	    
	    if(noNull(n)) {
	    	
	    	for (OrderDetail od : details) {
	    	
	    		if (n.equals(od.getRef())) result = od.getRef()+";"+od.getAmount()+";"+od.getPrice();
	    	}
	    }	    
	    
	    return result;
	}

	@Override
	public int updateDetail(int n, String newDetail) {
		
		String detail = getDetail(n);
		
		if(noNull(detail) && noNull(newDetail)){
			
			deleteDetail(n);
			setDetail(newDetail);
			
			return 0;			
		}
		else return -1;
	}

	@Override
	public int updateDetail(String n, String newDetail) {
		
		String detail = getDetail(n);
		
		if(noNull(detail) && noNull(newDetail)){
			
			deleteDetail(n);
			setDetail(newDetail);
			
			return 0;			
		}
		
		else return -1;
	}

	@Override
	public int deleteDetail(int n) {
		
		if (n == 0) n += 1;
			
		details.remove(n-1);
			
		return 0;	
	}

	@Override
	public int deleteDetail(String n) {
		
		if (noNull(n)) {
			
			for (OrderDetail od : details) {
			    	
				if (n.equals(od.getRef())) {
					 
					details.remove(od);
					 
					return 0;
				}
			}
		}
		
		return -1;
	}
	
	@Override
	public double getValue() {
		
		int total = 0;
		
		for (int i = 0; i < details.size(); i++) {
			
			total += details.get(i).getPrice();
		}
		
		return total;
	}
		
	private boolean noNull(String s) {
		
		if(s != null && s != "") return true;
		else return false;
	}
}
