package sample.jsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {

        try {

            URL myURL = new URL("http://localhost:4000");
            HttpURLConnection myURLConnection = (HttpURLConnection) myURL.openConnection();
            StringBuffer angularHtml = new StringBuffer();

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(myURLConnection.getInputStream()))) {
                reader.lines().forEach((htm)-> angularHtml.append(htm));
            }
            System.out.println("StringBuffer: " + angularHtml);
            model.put("angular", angularHtml);
//            URL url = new URL("http://localhost:4000");
//            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
//            httpCon.setDoOutput(true);
//            httpCon.setRequestMethod("GET");
//            OutputStreamWriter out = new OutputStreamWriter(
//                    httpCon.getOutputStream());
//            System.out.println(httpCon.getResponseCode());
//            System.out.println(httpCon.getResponseMessage());
//            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/foo")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }

}