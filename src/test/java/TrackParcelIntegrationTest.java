import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TrackParcelIntegrationTest {
    @Test
    public void test() throws IOException {
        String url = "http://swkomtest-env.us-east-1.elasticbeanstalk.com/parcel/PYJRB4HZ6";

        URLConnection connection = new URL(url).openConnection();

        InputStream response = connection.getInputStream();
        Scanner scanner = new Scanner(response);
        String responseBody = scanner.nextLine();

        assertEquals("{\"state\":\"Pickup\",\"visitedHops\":[],\"futureHops\":[]}", responseBody);

    }
}
