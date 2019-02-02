import org.junit.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Salty on 10/21/2018.
 */
public class HttpGet {

    static List<String> getMovieTitles(String substr) throws IOException {
        StringBuffer urlString = new StringBuffer("https://jsonmock.hackerrank.com/api/movies/search/?Title=%s");
        List<String> titles = new ArrayList<>();
        URL url = new URL(String.format(urlString.toString(), substr));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        InputStream is = url.openStream();
        JsonReader rdr = Json.createReader(is);

        JsonObject obj = rdr.readObject();
        int numberOfTitles = obj.getJsonNumber("total").intValue();
        int numberOfPages = obj.getJsonNumber("total_pages").intValue();

        JsonArray results = obj.getJsonArray("data");
        for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                 System.out.println(result.getString("Title", ""));
                 titles.add(result.getString("Title", ""));

         }
         is.close();

        int page = 2;
        while(page <= numberOfPages) {
             is = new URL(urlString.append("&page=").append(page).toString()).openStream();
             rdr = Json.createReader(is);

            results = obj.getJsonArray("data");
            for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                System.out.println(result.getString("Title", ""));
                titles.add(result.getString("Title", ""));
            }
            page++;
        }

        titles.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return titles;
    }

    @Test
    public void t1() throws IOException {
        assertEquals(Arrays.asList(""), getMovieTitles("spiderman"));
    }

}
