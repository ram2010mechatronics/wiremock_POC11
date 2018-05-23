package wiremock_try1;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.standalone.CommandLineOptions;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class runner {
    public  static void main (final String[] args){
        final String[] args2 = new String[args.length + 2];
        args2[args.length] = "--port";
        args2[args.length + 1] = "8082";
        CommandLineOptions options = new CommandLineOptions(args2);
        WireMockServer wireMockServer = new WireMockServer(options);
        wireMockServer.start();
        wireMockServer.stubFor(get(urlEqualTo("/api/get-magic"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"currently\":{\"windSpeed\":12.34}}")));
        wireMockServer.stubFor(get(urlEqualTo("/response-transform-with-params")).willReturn(
                aResponse()
                        .withTransformerParameter("name", "John")
                        .withTransformerParameter("number", 66)
                        .withTransformerParameter("flag", true)
                        .withBody("Original body")));


    }
}
