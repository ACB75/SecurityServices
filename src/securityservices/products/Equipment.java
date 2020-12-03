package securityservices.products;

public class Equipment extends PhysicalProduct implements Storable{
    protected String function, components;
    protected Integer power;

    public Equipment() {}

    public Equipment(String code, String name, String type, String maker, String description, 
            Double price, Double high, Double wide, Double deep, Double weight, Boolean fragile,
            String function, String components, Integer power) {
        super(code, name, type, maker, description, price, high, wide, deep, weight, fragile);
        this.function = function;
        this.components = components;
        this.power = power;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    @Override
    public String getDetails() {
        return "Function:" + function + ";Components:" + this.components;
    }   

    @Override
    public String getDimensions() {
        return  "W:"+ this.physics.getWide() + ";D:"+ this.physics.getDeep() + ";H:" + this.physics.getHigh();
    }

    @Override
    public Double getVolum() {
        return this.physics.getHigh() * this.physics.getWide() * this.physics.getDeep();
    }
}