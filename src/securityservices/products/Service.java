package securityservices.products;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Service extends Product {
    protected String periodicity, conditions;
    protected LocalDateTime startDate, finishDate;
    protected DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd'/'MM'/'yyyy'-'HH:mm:ss");

    public Service() {
    }

    public Service(String code, String name, String type, String maker, String description, double price,
            String periodicity, String conditions, String startDate, String finishDate) {
        super(code, name, type, maker, description, price);
        this.periodicity = periodicity;
        this.conditions = conditions;
        this.setBeginDate(startDate);
        this.setFinishDate(finishDate);
    }

    public String getBeginDate() {
        if (this.startDate != null) {
            return startDate.format(this.dateTimeFormat);
        }
        return "";
    }

    public void setBeginDate(String beginDate) throws DateTimeParseException{
        if (beginDate != null && beginDate.trim().length() > 0) {
            this.startDate = LocalDateTime.parse(beginDate, this.dateTimeFormat);
        }
    }

    public String getFinishDate() {
        if (this.finishDate != null) {
            return this.finishDate.format(this.dateTimeFormat);
        } 
        return "";
    }

    public void setFinishDate(String finishDate) throws DateTimeParseException{
        if (finishDate != null && finishDate.trim().length() > 0) {
            this.finishDate = LocalDateTime.parse(finishDate, this.dateTimeFormat);
        }
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String getDetails() {
        return "Periodicity:" + this.periodicity
                + ";Conditions:" + this.conditions;
    }
}