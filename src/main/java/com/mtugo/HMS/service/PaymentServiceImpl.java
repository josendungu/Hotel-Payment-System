package com.mtugo.HMS.service;

import com.mtugo.HMS.helpers.MPesa;
import com.mtugo.HMS.model.Payment;
import com.mtugo.HMS.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Base64;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {


    @Override
    public Payment makePayment(String phoneNumber) throws JSONException, IOException {
        MPesa mPesaHelper = MPesa.builder().appKey(Constants.APP_KEY).appSecret(Constants.APP_SECRET).build();

        ZoneId zoneId = ZoneId.of("Africa/Nairobi");
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now(zoneId));
        String s = new SimpleDateFormat("yyyyMMddHHmmss").format(timestamp);

        String businessShortCode = "174379";

        String passwordString = businessShortCode + Constants.PASS_KEY + s;
        String password = Base64.getEncoder().encodeToString(passwordString.getBytes(StandardCharsets.UTF_8));


        String response = mPesaHelper.STKPushSimulation(
                businessShortCode,
                password,
                s,
                "CustomerPayBillOnline",
                "1",
                phoneNumber,
                phoneNumber,
                businessShortCode,
                "https://mydomain.com/path",
                "https://mydomain.com/path",
                "Mtugo Hotel",
                "Order 12313"

        );

        System.out.println(response);

        return null;
    }
}
