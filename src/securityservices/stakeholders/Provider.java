package securityservices.stakeholders;

public class Provider extends Person implements StakeHolder{
    public Company companyData = new Company();
    public int delayPayment, valoration;
    public double discount;

    public Provider() {
    }

    public Provider(String name, String ident, String email, String phone, String address, String birthday,
                int delayPayment, int valoration, double discount, String socialReason, String type) {
        super(name, ident, email, phone, address, birthday);
        this.delayPayment = delayPayment;
        this.valoration = valoration;
        this.discount = discount;
        this.companyData.setSocialReason(socialReason);
        this.companyData.setType(type);
    }

    public int getDelayPayment() {
        return delayPayment;
    }

    public void setDelayPayment(int delayPayment) {
        this.delayPayment = delayPayment;
    }

    public int getValoration() {
        return valoration;
    }

    public void setValoration(int valoration) {
        this.valoration = valoration;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    @Override
    public String getCode() {
       return this.getCode();
    }

    @Override
    public String getType() {
        return "provider";
    }

    @Override
    public String getDetails() {
        return "companyType:" + this.companyData.type + 
               ";delayPayment:" + this.delayPayment + 
                ";discount:" + this.discount;
    }

}
