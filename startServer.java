package wiremock_try1;

import com.github.tomakehurst.wiremock.standalone.CommandLineOptions;
import com.github.tomakehurst.wiremock.standalone.WireMockServerRunner;

public class startServer {
    private static String filesRoot;

    public static void main(final String[] args) {
        final CommandLineOptions options = new CommandLineOptions( args );
        startServer.filesRoot = "R:\\WireMockCsv-master\\WireMockCsv-master\\src\\test\\resources";//options.filesRoot().getPath();
        final String[] args2 = new String[args.length + 6];
        System.arraycopy( args, 0, args2, 0, args.length );
        args2[args.length] = "--port";
        args2[args.length + 1] = "8081";
        args2[args.length + 2] = "--root-dir";
        args2[args.length + 3] = "R:\\WireMockCsv-master\\WireMockCsv-master\\src\\test\\resources";
        args2[args.length + 4] = "--extensions";
        args2[args.length + 5] = "wiremock_try1.wiremock_ext";
        WireMockServerRunner.main( args2 );

    }
    public static String filesRoot() {
        return startServer.filesRoot;
    }
}
