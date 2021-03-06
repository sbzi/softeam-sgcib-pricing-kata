package fr.softeam.sgcib.pricing.discount;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyManyGetSomeFreeDiscountStrategy implements DiscountStrategy {

    private BigDecimal bought;
    private BigDecimal free;

    public BuyManyGetSomeFreeDiscountStrategy(BigDecimal bought, BigDecimal free) {
        this.bought = bought;
        this.free = free;
    }


    @Override
    public BigDecimal apply(BigDecimal quantity) {
        return quantity.divide(bought, 0, RoundingMode.DOWN).multiply(free);
    }

    @Override
    public String getLabel() {
        return "Buy " + bought + ", " + free + " Free";
    }
}
