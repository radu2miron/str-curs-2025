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
        try (WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
            webClient.getOptions().setJavaScriptEnabled(false);
            HtmlPage page = webClient.getPage(CURS_BNR_URL);

            Optional<String> liTextOptional = page.getElementsByTagName("li").stream()
                    .map(li -> li.asNormalizedText())
                    .filter(text -> text.contains(ONE_EURO))
                    .findFirst();

            if (liTextOptional.isPresent()) {
                String liText = liTextOptional.get().trim();
                Optional<Double> rateOptional = Arrays.stream(liText.split("\n"))
                        .map(String::trim)
                        .filter(line -> line.startsWith(ONE_EURO))
                        .map(line -> line.replace(ONE_EURO, "").replace("Lei", "").trim())
                        .filter(s -> !s.isEmpty())
                        .map(Double::parseDouble)
                        .findFirst();

                if (rateOptional.isPresent()) {
                    return new Rate("EUR", "RON", rateOptional.get());
                }
            }
            return null;
        }
    }

}
