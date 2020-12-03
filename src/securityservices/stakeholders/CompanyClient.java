package securityservices.stakeholders;

public class CompanyClient extends Client implements StakeHolder{

    public Company companyData = new Company();
    
    public CompanyClient() {
    }

    public CompanyClient(String name, String ident, String email, String phone, String address, String birthday,
            String password, String deliveryAddres, int clientCode, int numEquipments, String socialReason, String type) {
        super(name, ident, email, phone, address, birthday, password, deliveryAddres, clientCode, numEquipments);
    
        this.companyData.setSocialReason(socialReason);
        this.companyData.setType(type);
    }
    
    @Override
    public String getType() {
        return "companyclient";
    }
    
    @Override
    public String getDetails() {
        return super.getDetails() + ";companyType" + this.companyData.getType();
    }
}