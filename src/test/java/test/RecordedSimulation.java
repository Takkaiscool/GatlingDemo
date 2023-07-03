package test;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("http://computer-database.gatling.io")
      .inferHtmlResources()
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.9")
      .doNotTrackHeader("1")
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Cache-Control", "max-age=0");
    headers_0.put("Proxy-Connection", "keep-alive");
    headers_0.put("Upgrade-Insecure-Requests", "1");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("Accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8");
    headers_1.put("Proxy-Connection", "keep-alive");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("Proxy-Connection", "keep-alive");
    headers_2.put("Upgrade-Insecure-Requests", "1");
    
    Map<CharSequence, String> headers_3 = new HashMap<>();
    headers_3.put("Cache-Control", "max-age=0");
    headers_3.put("Origin", "http://computer-database.gatling.io");
    headers_3.put("Proxy-Connection", "keep-alive");
    headers_3.put("Upgrade-Insecure-Requests", "1");


    ScenarioBuilder scn = scenario("RecordedSimulation")
      .exec(
        http("request_0")
          .get("/")
          .headers(headers_0)
          .resources(
            http("request_1")
              .get("/favicon.ico")
              .headers(headers_1)
              .check(status().is(404))
          )
      )
      .pause(2)
      .exec(
        http("request_2")
          .get("/computers/new")
          .headers(headers_2)
      )
      .pause(5)
      .exec(
        http("request_3")
          .post("/computers")
          .headers(headers_3)
          .formParam("name", "test")
          .formParam("introduced", "test")
          .formParam("discontinued", "test")
          .formParam("company", "1")
          .check(status().is(400))
      )
      .pause(9)
      .exec(
        http("request_4")
          .post("/computers")
          .headers(headers_3)
          .formParam("name", "test")
          .formParam("introduced", "3213")
          .formParam("discontinued", "321")
          .formParam("company", "2")
          .check(status().is(400))
      )
      .pause(1)
      .exec(
        http("request_5")
          .get("/computers")
          .headers(headers_2)
      );

	  setUp(scn.injectOpen(atOnceUsers(151
      ))).protocols(httpProtocol);
  }
}
