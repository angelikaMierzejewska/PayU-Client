package com.example.payuClient;

import com.example.payuClient.model.OrderRequest;
import com.example.payuClient.model.Product;
import org.junit.Before;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class PayuClientApplicationTests {

	final String authToken = "d9a4536e-62ba-4f60-8017-6053211d3f47";
	private PayuClient payuClient;

	@Before
	public void setup(){
		payuClient = new PayuClient(authToken);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void givenCorrectObject(){
		Product p1 = new Product("Trousers", "20000", "1");
		Product p2 = new Product("Skirt", "11000", "1");
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		OrderRequest orderRequest = new OrderRequest("https://your.eshop.com/notify", "127.0.0.1",  "300746", "RTV market", "PLN","0");
		orderRequest.setProducts(products);

		Response response = payuClient.createOrder(orderRequest);

		assertEquals(302, response.getStatus());
	}
}
