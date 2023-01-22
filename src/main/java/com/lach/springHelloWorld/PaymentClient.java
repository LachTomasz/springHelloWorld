package com.lach.springHelloWorld;

class PaymentClient {

  /*
You are provided with a PaymentClient class with a template method and that returns a "PaymentResponse"
object
You are given a list of PaymentRequest objects - for ex -

Otrzymujesz klasę PaymentClient z metodą szablonu, która zwraca „PaymentResponse”
obiekt.
Dostajesz listę obiektów PaymentRequest - na przykład -
[{
  "token": "123",
  "cardType": "AMEX"
},
{
  "token": "456",
  "cardType": "GIFTCARD"
  }
]
You will have to write a service class + method (which takes list as input parameter) that can call this method "charge" for
 ALL the payment request objects in the list
You will have to void (call the voidCharge) for the "successfully" charged requests if there are any failures for others
Your code should take care of happy + unhappy path
Your code should scale if the list increases
(Add Unit tests for all use cases and let the code run with some mock data to show how the service takes care of all use cases )

Będziesz musiał napisać klasę usługi + metodę (która przyjmuje listę jako parametr wejściowy),
który może nazwać tę metodę „obciążeniem” dla WSZYSTKICH obiektów żądań płatności na liście.
Będziesz musiał anulować (wywołać voidCharge) dla żądań „pomyślnie” obciążonych, jeśli wystąpią jakiekolwiek awarie dla innych.
Twój kod powinien zadbać o ścieżkę happy + happy.
Twój kod powinien skalować się, jeśli lista się zwiększa
(Dodaj testy jednostkowe dla wszystkich przypadków użycia i pozwól kodowi działać z niektórymi próbnymi danymi, aby pokazać, w jaki sposób usługa zajmuje się wszystkimi przypadkami użycia)

*/

  /* mam 5 PaymentRequestow
  wywoluje dla nich charge
  jesli przynajmniej 1 nie przejdzie to dla tych ktore przeszly musze wywolac voidCharge


   */

    public PaymentResponse charge(PaymentRequest paymentRequest) {
    /*
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.charged = true;
        paymentResponse.status = "SUCCESS";
        paymentResponse.token = "123";
        paymentResponse.cardType = "AMEX";
        return paymentResponse;
    */
    //*
        PaymentResponse paymentResponse = new PaymentResponse();
    paymentResponse.charged = false;
    paymentResponse.status = "FAILURE";
    paymentResponse.token = "123";
    paymentResponse.cardType = "AMEX";
    return paymentResponse;
    //*/
    }

    public PaymentResponse voidCharge(PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.voided = true;
        paymentResponse.status = "SUCCESS";
        paymentResponse.token = "123";
        paymentResponse.cardType = "AMEX";
        return paymentResponse;
    }

}
