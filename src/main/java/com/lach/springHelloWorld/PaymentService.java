package com.lach.springHelloWorld;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PaymentService {

   private final PaymentClient paymentClient;

    public PaymentService(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    public List<PaymentResponse> chargeRequest(List<PaymentRequest> requests){

        Map<PaymentResponse, PaymentRequest> paymentResponseToRequest = requests.stream()
                .collect(Collectors.toMap(paymentClient::charge, v -> v));

        boolean anyPaymentFailed = paymentResponseToRequest.keySet().stream()
                .anyMatch(paymentResponse -> !paymentResponse.charged);
        if (anyPaymentFailed){
            paymentResponseToRequest.entrySet().stream()
                    .filter(paymentResponsePaymentRequestEntry -> paymentResponsePaymentRequestEntry.getKey().charged)
                    .forEach(paymentResponsePaymentRequestEntry -> paymentClient.voidCharge(paymentResponsePaymentRequestEntry.getValue()));
        }

        return paymentResponseToRequest.keySet().stream().toList();
    }
}
