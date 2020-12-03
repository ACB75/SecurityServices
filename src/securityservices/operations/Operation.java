package securityservices.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public abstract class Operation {

    protected int creator;
    protected double value, surcharges;
    protected String code, type, status, additonalInfo;
    protected LocalDateTime initDate, finishDate;
    protected DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd'/'MM'/'yyyy'-'HH:mm:ss");

    public Operation() {
    }

    public Operation(String code, int creator, double value, double surcharges, String type,
            String status, String additonalInfo, String initDate, String finishDate) {
        this.code = code;
        this.creator = creator;
        this.value = value;
        this.surcharges = surcharges;
        this.type = type;
        this.status = status;
        this.additonalInfo = additonalInfo;
        this.setBeginDate(initDate);
        this.setFinishDate(finishDate);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getSurcharges() {
        return surcharges;
    }

    public void setSurcharges(double surcharges) {
        this.surcharges = surcharges;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdditonalInfo() {
        return additonalInfo;
    }

    public void setAdditonalInfo(String additonalInfo) {
        this.additonalInfo = additonalInfo;
    }

    public String getBeginDate() {
        if (this.initDate != null) {
            return this.initDate.format(this.dateTimeFormatter);
        } 
        return "";
    }

    public void setBeginDate(String beginDate) throws DateTimeParseException {
        if (beginDate != null && beginDate.trim().length() > 0) {
            this.initDate = LocalDateTime.parse(beginDate, this.dateTimeFormatter);
        }
    }

    public String getFinishDate() {
        if (this.finishDate != null) {
            return this.finishDate.format(this.dateTimeFormatter);
        } 
        return "";
    }

    public void setFinishDate(String finishDate) throws DateTimeParseException{
        if (finishDate != null && finishDate.trim().length() > 0) {
            this.finishDate = LocalDateTime.parse(finishDate, this.dateTimeFormatter);
        }
    }
}
