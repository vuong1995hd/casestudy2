package model;

public class Discount {
    private String code;
    private double percentage;

    public Discount(String code, double percentage) {
        this.code = code;
        this.percentage = percentage;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }
}
