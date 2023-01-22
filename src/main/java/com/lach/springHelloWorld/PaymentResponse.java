package com.lach.springHelloWorld;

import java.util.Objects;

class PaymentResponse {
    public String status;
    public boolean charged;
    public boolean voided;
    public String token;
    public String cardType;

    public PaymentResponse(String status, boolean charged, boolean voided, String token, String cardType) {
        this.status = status;
        this.charged = charged;
        this.voided = voided;
        this.token = token;
        this.cardType = cardType;
    }

    public PaymentResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentResponse that = (PaymentResponse) o;
        return charged == that.charged && voided == that.voided && Objects.equals(status, that.status) && Objects.equals(token, that.token) && Objects.equals(cardType, that.cardType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, charged, voided, token, cardType);
    }
}