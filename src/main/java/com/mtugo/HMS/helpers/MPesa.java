package com.mtugo.HMS.helpers;

import java.io.IOException;


import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.json.*;

import java.util.Base64;
import java.util.Objects;

@Data
@Builder
@Slf4j
public class MPesa {

    private final String appKey;
    private final String appSecret;


    public MPesa(String app_key, String app_secret) {
        appKey = app_key;
        appSecret = app_secret;
    }


    public String authenticate() throws IOException, JSONException {

        String appKeySecret = appKey + ":" + appSecret;
        byte[] bytes = appKeySecret.getBytes("ISO-8859-1");
        String encoded = Base64.getEncoder().encodeToString(bytes);


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .get()
                .addHeader("authorization", "Basic " + encoded)
                .addHeader("cache-control", "no-cache")

                .build();

        Response response = client.newCall(request).execute();
        JSONObject jsonObject = new JSONObject(Objects.requireNonNull(response.body()).string());
        return jsonObject.getString("access_token");


    }


    public String STKPushSimulation(String businessShortCode, String password, String timestamp, String transactionType, String amount, String phoneNumber, String partyA, String partyB, String callBackURL, String queueTimeOutURL, String accountReference, String transactionDesc) throws IOException, JSONException {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("BusinessShortCode", businessShortCode);
        jsonObject.put("Password", password);
        jsonObject.put("Timestamp", timestamp);
        jsonObject.put("TransactionType", transactionType);
        jsonObject.put("Amount", amount);
        jsonObject.put("PhoneNumber", phoneNumber);
        jsonObject.put("PartyA", partyA);
        jsonObject.put("PartyB", partyB);
        jsonObject.put("CallBackURL", callBackURL);
        jsonObject.put("AccountReference", accountReference);
        jsonObject.put("QueueTimeOutURL", queueTimeOutURL);
        jsonObject.put("TransactionDesc", transactionDesc);


        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");

        OkHttpClient client = new OkHttpClient();
        String url = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(requestJson, mediaType);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer " + authenticate())
                .addHeader("cache-control", "no-cache")
                .build();


        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        return response.body().toString();
    }

}
