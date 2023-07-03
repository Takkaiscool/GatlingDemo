package test;

import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;

public class test {
    public static void main(String[] args) {
        GatlingPropertiesBuilder propertiesBuilder=new GatlingPropertiesBuilder().resourcesDirectory("./test/resources").resultsDirectory("./");
        Gatling.fromMap(propertiesBuilder.build());
    }
}

