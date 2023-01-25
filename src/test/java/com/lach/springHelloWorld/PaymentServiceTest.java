package com.lach.springHelloWorld;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class PaymentServiceTest {

    PaymentClient paymentClient = mock(PaymentClient.class);
    PaymentService paymentService = new PaymentService(paymentClient);

    @Test
    void shouldChargeAllRequests() {

        //Given
        PaymentRequest reqeust1 = new PaymentRequest("123", "AMEX");
        PaymentRequest request2 = new PaymentRequest("321", "VISA");
        PaymentRequest request3 = new PaymentRequest("890", "MASTERCARD");

        List<PaymentRequest> requests = List.of(reqeust1, request2, request3);

        PaymentResponse response1 = new PaymentResponse("Success", true, false, reqeust1.token, reqeust1.cardType);
        PaymentResponse response2 = new PaymentResponse("Success", true, false, request2.token, request2.cardType);
        PaymentResponse response3 = new PaymentResponse("Success", true, false, request3.token, request3.cardType);

        given(paymentClient.charge(reqeust1)).willReturn(response1);
        given(paymentClient.charge(request2)).willReturn(response2);
        given(paymentClient.charge(request3)).willReturn(response3);


        //When
        List<PaymentResponse> result = paymentService.chargeRequest(requests);

        //Then
        assertThat(result).containsExactlyInAnyOrder(response1, response2, response3);//róznica set a mapa
    }

    @Test
    void shouldVoidChargedRequestWhenAnyRequestFailed () {

        //Given
        PaymentRequest reqeust1 = new PaymentRequest("123", "AMEX");
        PaymentRequest request2 = new PaymentRequest("321", "VISA");
        PaymentRequest request3 = new PaymentRequest("890", "MASTERCARD");

        List<PaymentRequest> requests = List.of(reqeust1, request2, request3);

        PaymentResponse response1 = new PaymentResponse("Success", true, false, reqeust1.token, reqeust1.cardType);
        PaymentResponse response2 = new PaymentResponse("Failure", false, false, request2.token, request2.cardType);
        PaymentResponse response3 = new PaymentResponse("Success", true, false, request3.token, request3.cardType);

        given(paymentClient.charge(reqeust1)).willReturn(response1);
        given(paymentClient.charge(request2)).willReturn(response2);
        given(paymentClient.charge(request3)).willReturn(response3);


        //When
        List<PaymentResponse> result = paymentService.chargeRequest(requests);

        //Then
        assertThat(result).containsExactlyInAnyOrder(response1, response2, response3);//róznica set a mapa
        verify(paymentClient).voidCharge(reqeust1);
        verify(paymentClient).voidCharge(request3);
    }
}