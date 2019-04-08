package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.junit.Assert.*;

public class DefaultTaxCalculatorTest {

    private DefaultTaxCalculator defaultTaxCalculator;
    private Tax tax;
    private RequestItem requestItem;
    private ProductData productData;
    private Money money;

    @Before
    public void setUp(){
        defaultTaxCalculator = new DefaultTaxCalculator();
        money = new Money(10, Money.DEFAULT_CURRENCY);
    }

    @Test
    public void taxFOOD(){
        productData = new ProductData(Id.generate(), new Money(20, Money.DEFAULT_CURRENCY), "TEST", ProductType.FOOD, new Date());
        requestItem = new RequestItem(productData, 10, money);
        tax = defaultTaxCalculator.calculateTax(requestItem);
        assertEquals("7% (F)" ,tax.getDescription());
    }

    @Test
    public void taxSTANDARD(){
        productData = new ProductData(Id.generate(), new Money(20, Money.DEFAULT_CURRENCY), "TEST", ProductType.STANDARD, new Date());
        requestItem = new RequestItem(productData, 10, money);
        tax = defaultTaxCalculator.calculateTax(requestItem);
        assertEquals("23%" ,tax.getDescription());
    }

    @Test
    public void taxDRUG(){
        productData = new ProductData(Id.generate(), new Money(20, Money.DEFAULT_CURRENCY), "TEST", ProductType.DRUG, new Date());
        requestItem = new RequestItem(productData, 10, money);
        tax = defaultTaxCalculator.calculateTax(requestItem);
        assertEquals("5% (D)" ,tax.getDescription());
    }

}