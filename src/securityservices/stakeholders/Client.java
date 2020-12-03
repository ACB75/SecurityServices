package securityservices.stakeholders;

public class Client extends Person implements StakeHolder{
    protected String password, deliveryAddres;
    protected int clientCode, numEquipments;

    public Client() {
    }

    public Client(String name, String ident, String email, String phone, String address, String birthday,
                    String password, String deliveryAddres, int clientCode, int numEquipments) {
        super(name, ident, email, phone, address, birthday);
        this.password = password;
        this.deliveryAddres = deliveryAddres;
        this.clientCode = clientCode;
        this.numEquipments = numEquipments;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeliveryAddres() {
        return deliveryAddres;
    }

    public void setDeliveryAddres(String deliveryAddres) {
        this.deliveryAddres = deliveryAddres;
    }

    public int getClientCode() {
        return clientCode;
    }

    public void setClientCode(int clientCode) {
        this.clientCode = clientCode;
    }

    public int getNumEquipments() {
        return numEquipments;
    }

    public void setNumEquipments(int numEquipments) {
        this.numEquipments = numEquipments;
    }

    @Override
    public String getType() {
        return "simpleclient";
    }

    @Override
    public String getDetails() {
        return "clientcode:" + this.clientCode + ";equipments:" + this.numEquipments;
    }
}