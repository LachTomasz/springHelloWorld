package com.lach.springHelloWorld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PaymentService {

    public List<PaymentResponse> chargeRequest(List<PaymentRequest> requests){

        List<PaymentResponse> paymentResponses = requests.stream()
                .map(paymentRequest -> new PaymentClient().charge(paymentRequest)).toList();

        boolean status = paymentResponses.stream()
                .anyMatch(paymentResponse -> paymentResponse.charged);
        if (!status) paymentResponses = requests.stream()
                .map(paymentRequest -> new PaymentClient().voidCharge(paymentRequest)).toList();

        return paymentResponses;
    }
}
