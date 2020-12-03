package securityservices.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import securityservices.shared.PhysicalData;

public class TransportableOrder extends Order implements Transportable {

    protected String transporter, deliveryAddress, receiverName;
    protected PhysicalData physics;
    protected LocalDateTime receptionDate;

    public TransportableOrder() {
        this.physics = new PhysicalData();
    }

    public TransportableOrder(String code, int creator, double value, double surcharges, String type, String status,
            String additonalInfo, String beginDate, String finishDate, String paymentType, String paymentDate,
            String transporter, String deliveryAddres, String receiverName, String receptionDate) {
        super(code, creator, value, surcharges, type, status, additonalInfo, beginDate, finishDate, paymentType, paymentDate);
        this.transporter = transporter;
        this.deliveryAddress = deliveryAddres;
        this.receiverName = receiverName;
        this.physics = new PhysicalData();
        this.setReceptionDate(receptionDate);
    }

    public TransportableOrder(String code, int creator, double value, double surcharges, String type, String status,
            String additonalInfo, String beginDate, String finishDate, String paymentType, String paymentDate,
            String transporter, String deliveryAddres, String receiverName, String receptionDate,
            Double high, Double wide, Double deep, Double weight, Boolean fragile) {
        super(code, creator, value, surcharges, type, status, additonalInfo, beginDate, finishDate, paymentType, paymentDate);
        this.transporter = transporter;
        this.deliveryAddress = deliveryAddres;
        this.receiverName = receiverName;
        this.physics = new PhysicalData(high, wide, deep, weight, fragile);
        this.setReceptionDate(receptionDate);
    }

    public String getReceptionDate() {
        if (this.receptionDate != null) {
            return this.receptionDate.format(this.dateTimeFormatter);
        }
        return "";
    }

    public void setReceptionDate(String receptionDate) throws DateTimeParseException {
        if (receptionDate != null && receptionDate.trim().length() > 0) {
            this.receptionDate = LocalDateTime.parse(receptionDate, this.dateTimeFormatter);
        }
    }

    @Override
    public String getTransporter() {
        return this.transporter;
    }

    public void setTransporter(String transporter) {
        this.transporter = transporter;
    }

    @Override
    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddres) {
        this.deliveryAddress = deliveryAddres;
    }

    @Override
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Double getHigh() {
        return this.physics.getHigh();
    }

    public void setHigh(Double high) {
        this.physics.setHigh(high);
    }

    public Double getWide() {
        return this.physics.getWide();
    }

    public void setWide(Double wide) {
        this.physics.setWide(wide);
    }

    public Double getDeep() {
        return this.physics.getDeep();
    }

    public void setDeep(Double deep) {
        this.physics.setDeep(deep);
    }

    @Override
    public Double getWeight() {
        return this.physics.getWeight();
    }

    public void setWeight(Double weight) {
        this.physics.setWeight(weight);
    }

    @Override
    public Boolean isFragile() {
        return this.physics.getFragile();
    }

    public void setFragile(Boolean fragile) {
        this.physics.setFragile(fragile);
    }

    @Override
    public String getDimensions() {
        return "W:" + this.physics.getWide() + ";D:" + this.physics.getDeep() + ";H:" + this.physics.getHigh();
    }

    @Override
    public Double getVolum() {
        return this.physics.getHigh() * this.physics.getWide() * this.physics.getDeep();
    }
}
