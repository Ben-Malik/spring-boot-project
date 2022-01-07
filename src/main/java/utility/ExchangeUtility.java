package utility;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bao.baoltd.model.Exchange;
import com.bao.baoltd.service.ExchangeManager;

/**
 * A helper component to handle the exchange rate on the website.
 * @author ben-malik
 */
@EnableScheduling
@Configuration
@Component
public class ExchangeUtility {

	@Autowired
	private ExchangeManager manager;

    @Scheduled(cron="0 0/3 * * * ?")
	public void getTheExchanges() throws InterruptedException {

		String urlEuro = "https://free.currconv.com/api/v7/convert?q=EUR_TRY&compact=ultra&apiKey=ac495209d6cdd9e87736";
		String urlDolar = "https://free.currconv.com/api/v7/convert?q=USD_TRY&compact=ultra&apiKey=ac495209d6cdd9e87736";

		RestTemplate template = new RestTemplate();
		ResponseEntity<String> jsonEURO = template.getForEntity(urlEuro, String.class);
		ResponseEntity<String> jsonDOLAR = template.getForEntity(urlDolar, String.class);

		String euro = jsonEURO.getBody().split(":")[1].split("}")[0];
		String dollar = jsonDOLAR.getBody().split(":")[1].split("}")[0];

		System.out.println("Euro: " + euro + " Dollar: " + dollar + " Time: " + new Date().toString());

		Exchange usd = manager.getByName("dollar").isPresent()? manager.getByName("dollar").get() : null;
		Exchange eur = manager.getByName("euro").isPresent() ? manager.getByName("euro").get() : null;
		if (usd != null && euro != null) {
			usd.setAmount(new BigDecimal(dollar));
			usd.setCreatedAt(new Date());
			manager.create(usd);
			
			eur.setAmount(new BigDecimal(euro));
			eur.setCreatedAt(new Date());
			manager.create(eur);
		} else {
			manager.create(createExchange("dollar", dollar));
			manager.create(createExchange("euro", euro));
		}
	}

    /**
     * A helper method to create an exchange object with given properties.
     * @param name the name of the exchange.
     * @param amount the amount of the exchange.
     * @return 
     */
	private Exchange createExchange(String name, String amount) {
		Exchange exchange = new Exchange();
		exchange.setAmount(new BigDecimal(amount));
		exchange.setName(name);
		exchange.setCreatedAt(new Date());
		return exchange;
	}
	
	@Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }

}
