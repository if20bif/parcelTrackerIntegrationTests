import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class SubmitParcelIntegrationTest {
    @Test
    public void test() throws IOException {
        String url = "http://swkomtest-env.us-east-1.elasticbeanstalk.com/parcel/PYJRB4HZ6";
        String requestString = "{\"weight\":1,\"recipient\":{\"name\":\"Rudi\",\"street\":\"Hauptstrasse 1\",\"postalCode\":\"A-1020\",\"city\":\"Vienna\",\"country\":\"Austria\"},\"sender\":{\"name\":\"Susi\",\"street\":\"Wasserzeile 12\",\"postalCode\":\"A-2111\",\"city\":\"Tresdorf\",\"country\":\"Austria\"}}";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);



        OutputStream os = connection.getOutputStream();
        byte[] input = requestString.getBytes("utf-8");
        os.write(input, 0, input.length);

        assertEquals(200, connection.getResponseCode());

    }
}
