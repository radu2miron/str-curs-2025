package edu.tucn.str.lecture2.ex4interrupted;

import org.htmlunit.BrowserVersion;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class ExchageRateReader {
    private static final String CURS_BNR_URL = "https://www.cursbnr.ro/";
    private static final String ONE_EURO = "1 EURO =";

    public static Rate getExchangeRates() throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage page = webClient.getPage(CURS_BNR_URL);
        String rateAsHtmlLiOptional = page.getElementsByTagName("li").stream()
                .map(li -> li.asNormalizedText())
                .filter(li -> li.contains(ONE_EURO))
                .findFirst()
                .orElse(null);

        if(rateAsHtmlLiOptional != null) {
            String rateAsString = Arrays.stream(rateAsHtmlLiOptional.trim().split("\n"))
                    .map(String::trim)
                    .filter(line -> line.startsWith(ONE_EURO))
                    .map(l -> l.replace(ONE_EURO, "").replace("Lei", "").trim())
                    .findFirst()
                    .orElse(null);

            if(rateAsString != null) {
                double rateAsDouble = Double.parseDouble(rateAsString);
                return new Rate("EUR", "RON", rateAsDouble);
            }
        }

        return null;
    }
}
