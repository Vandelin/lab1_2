package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public class DefaultTaxCalculator implements TaxCalculator {
    @Override
    public Tax calculateTax(RequestItem requestItem) {
        Money net = requestItem.getTotalCost();
        BigDecimal ratio;
        String desc;

        switch (requestItem.getProductData()
                .getType()) {
            case FOOD:
                ratio = BigDecimal.valueOf(0.07);
            desc = "7% (F)";
                break;
            case STANDARD:
                ratio = BigDecimal.valueOf(0.23);
                desc = "23%";
                break;
            case DRUG:
                ratio = BigDecimal.valueOf(0.05);
                desc = "5% (D)";
                break;
            default:
                throw new IllegalArgumentException(requestItem.getProductData()
                        .getType()
                        + " not handled");
        }
        return new Tax(net.multiplyBy(ratio), desc);
    }
}
