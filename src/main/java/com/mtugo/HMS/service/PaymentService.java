package com.mtugo.HMS.service;

import com.mtugo.HMS.model.Payment;
import org.json.JSONException;

import java.io.IOException;

public interface PaymentService {

    Payment makePayment(String phoneNumber) throws JSONException, IOException;

}
