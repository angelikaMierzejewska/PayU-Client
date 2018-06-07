package com.example.payuClient;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import com.example.payuClient.model.OrderRequest;
import com.example.payuClient.model.OrderResponse;
import com.example.payuClient.model.Product;
import java.util.ArrayList;
import java.util.List;

public class PayuClientApplication {

	public static void main(String[] args) {

		final String authToken = "d9a4536e-62ba-4f60-8017-6053211d3f47";
        PayuClient client = new PayuClient(authToken);

		Product p1 = new Product("Trousers", "20000", "1");
        Product p2 = new Product("Skirt", "11000", "1");
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
	    OrderRequest orderRequest= new OrderRequest("https://your.eshop.com/notify", "127.0.0.1",  "300746", "RTV market", "PLN","0");
        orderRequest.setProducts(products);

		try {
			Response response = client.createOrder(orderRequest);

			if (response.getStatus() != 302) {
				response.close();
				System.out.println("Unexpected status code returned from server");
			}
			OrderResponse orderResponse = response.readEntity(OrderResponse.class);
			System.out.println("Payu url " +  orderResponse.getRedirectUri());
            System.out.println(response.getStatus());

		} catch (ProcessingException | WebApplicationException ex) {
			ex.printStackTrace();
		}
	}
}

