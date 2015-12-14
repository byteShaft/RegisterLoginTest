package com.byteshaft.registerlogintest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Helpers {

    public static String getSessionId(String email, String password, String url)
            throws IOException, JSONException {

        String data = String.format("{\"email\" : \"%s\", \"password\" : \"%s\"}", email, password);
        HttpURLConnection connection = openConnectionForUrl(url);
        sendRequestData(connection, data);
        JSONObject jsonObj = readResponse(connection);
        return (String) jsonObj.get("session_id");
    }

    private static HttpURLConnection openConnectionForUrl(String path)
            throws IOException {

        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("X-DreamFactory-Application-Name", String.valueOf(
                AppGlobals.getContext().getApplicationInfo().labelRes));
        connection.setRequestMethod("POST");
        return connection;
    }

    private static JSONObject readResponse(HttpURLConnection connection)
            throws IOException, JSONException {

        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder response = new StringBuilder();
        while((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        return new JSONObject(response.toString());
    }

    private static void sendRequestData(HttpURLConnection connection, String body)
            throws IOException {

        byte[] outputInBytes = body.getBytes("UTF-8");
        OutputStream os = connection.getOutputStream();
        os.write(outputInBytes);
        os.close();
    }

}
