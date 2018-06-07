package com.example.payuClient;

import com.example.payuClient.model.OrderRequest;
import org.glassfish.jersey.client.ClientProperties;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class PayuClient {

    private static final String uri = "https://secure.snd.payu.com/api/v2_1/orders";
    private Client client = ClientBuilder.newClient();
    private String authToken;

    public PayuClient(String authToken) {
        this.authToken = authToken;
    }

    public Response createOrder(OrderRequest orderRequest){
        return client
                .target(uri)
                .property(ClientProperties.FOLLOW_REDIRECTS, false)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + authToken)
                .post(Entity.entity(orderRequest, MediaType.APPLICATION_JSON));
    }
}





