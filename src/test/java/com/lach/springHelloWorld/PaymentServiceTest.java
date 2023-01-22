package com.lach.springHelloWorld;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    PaymentService paymentService = new PaymentService();

    @Test
    void shouldChargeRequestTrue() {

        //Given
        List<PaymentRequest> requests = List.of(new PaymentRequest("123", "AMEX"),
                                                new PaymentRequest("321", "VISA"),
                                                new PaymentRequest("894", "AMEX"),
                                                new PaymentRequest("795", "MASTERCARD"),
                                                new PaymentRequest("890", "MASTERCARD"));

        //When
        List<PaymentResponse> result = paymentService.chargeRequest(requests);

        //Then
        assertThat(result.get(0).charged).isTrue();
        assertThat(result.get(0).voided).isFalse();
        assertThat(result.get(0).status).isEqualTo("SUCCESS");
        assertThat(result.get(0).token).isEqualTo("123");
        assertThat(result.get(0).cardType).isEqualTo("AMEX");

        assertThat(result.get(1).charged).isTrue();
        assertThat(result.get(0).voided).isFalse();
        assertThat(result.get(1).status).isEqualTo("SUCCESS");
        assertThat(result.get(1).token).isEqualTo("123");
        assertThat(result.get(1).cardType).isEqualTo("AMEX");

        assertThat(result.get(2).charged).isTrue();
        assertThat(result.get(0).voided).isFalse();
        assertThat(result.get(2).status).isEqualTo("SUCCESS");
        assertThat(result.get(2).token).isEqualTo("123");
        assertThat(result.get(2).cardType).isEqualTo("AMEX");

        assertThat(result.get(3).charged).isTrue();
        assertThat(result.get(0).voided).isFalse();
        assertThat(result.get(3).status).isEqualTo("SUCCESS");
        assertThat(result.get(3).token).isEqualTo("123");
        assertThat(result.get(3).cardType).isEqualTo("AMEX");

        assertThat(result.get(4).charged).isTrue();
        assertThat(result.get(0).voided).isFalse();
        assertThat(result.get(4).status).isEqualTo("SUCCESS");
        assertThat(result.get(4).token).isEqualTo("123");
        assertThat(result.get(4).cardType).isEqualTo("AMEX");
    }

    @Test
    void shouldChargeRequestFalse() {

        //Given
        List<PaymentRequest> requests = List.of(new PaymentRequest("123", "AMEX"),
                new PaymentRequest("321", "VISA"),
                new PaymentRequest("894", "AMEX"),
                new PaymentRequest("795", "MASTERCARD"),
                new PaymentRequest("890", "MASTERCARD"));

        //When
        List<PaymentResponse> result = paymentService.chargeRequest(requests);

        //Then
        assertThat(result.get(0).charged).isFalse();
        assertThat(result.get(0).voided).isTrue();
        assertThat(result.get(0).status).isEqualTo("SUCCESS");
        assertThat(result.get(0).token).isEqualTo("123");
        assertThat(result.get(0).cardType).isEqualTo("AMEX");

        assertThat(result.get(1).charged).isFalse();
        assertThat(result.get(0).voided).isTrue();
        assertThat(result.get(1).status).isEqualTo("SUCCESS");
        assertThat(result.get(1).token).isEqualTo("123");
        assertThat(result.get(1).cardType).isEqualTo("AMEX");

        assertThat(result.get(2).charged).isFalse();
        assertThat(result.get(0).voided).isTrue();
        assertThat(result.get(2).status).isEqualTo("SUCCESS");
        assertThat(result.get(2).token).isEqualTo("123");
        assertThat(result.get(2).cardType).isEqualTo("AMEX");

        assertThat(result.get(3).charged).isFalse();
        assertThat(result.get(0).voided).isTrue();
        assertThat(result.get(3).status).isEqualTo("SUCCESS");
        assertThat(result.get(3).token).isEqualTo("123");
        assertThat(result.get(3).cardType).isEqualTo("AMEX");

        assertThat(result.get(4).charged).isFalse();
        assertThat(result.get(0).voided).isTrue();
        assertThat(result.get(4).status).isEqualTo("SUCCESS");
        assertThat(result.get(4).token).isEqualTo("123");
        assertThat(result.get(4).cardType).isEqualTo("AMEX");
    }
}