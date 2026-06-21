package customer.medical_erp;

import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.cds.CdsReadEventContext;

import java.util.List;
import java.util.Map;

@ServiceName("CatalogService")
public class ProductServiceHandler implements EventHandler {

    @After(event = "READ", entity = "CatalogService.Products")
    public void afterRead(CdsReadEventContext context, List<Map<String, Object>> products) {

        for (Map<String, Object> product : products) {

            Integer stock = (Integer) product.get("stock");

            if (stock != null && stock < 100) {
                System.out.println("Low Stock Product: " + product.get("name"));
            }
        }
    }
}