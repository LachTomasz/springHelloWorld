package com.lach.springHelloWorld;

class PaymentRequest {
    public String token;
    public String cardType;

    public PaymentRequest(String token, String cardType) {
        this.token = token;
        this.cardType = cardType;
    }
}