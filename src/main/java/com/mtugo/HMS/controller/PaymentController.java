package com.mtugo.HMS.controller;


import com.mtugo.HMS.model.Payment;
import com.mtugo.HMS.service.PaymentServiceImpl;
import org.json.JSONException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/v1/payments")
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/{phoneNumber}")
    public Payment makePayment(@PathVariable("phoneNumber") String phoneNumber ) throws JSONException, IOException {

        return paymentService.makePayment(phoneNumber);
    }


}
