package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;

import java.util.List;

public class InvoiceDataInfo {

    private ClientData client;
    private List<RequestItem> items;

    public InvoiceDataInfo(ClientData client, List<RequestItem> items) {
        this.client = client;
        this.items = items;
    }

    public ClientData getClient() {
        return client;
    }

    public void setClient(ClientData client) {
        this.client = client;
    }

    public List<RequestItem> getItems() {
        return items;
    }

    public void setItems(List<RequestItem> items) {
        this.items = items;
    }
}
