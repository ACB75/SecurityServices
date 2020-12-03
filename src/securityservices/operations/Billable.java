package securityservices.operations;

public interface Billable {
		
	public int getNumDetails ();
	public int setDetail (String detail);
	public String getDetail (int n);
	public String getDetail (String n);
	public int updateDetail (int n, String newdetail); 
	public int updateDetail (String n, String newdetail); 
	public int deleteDetail (int n); 
	public int deleteDetail (String n); 
}