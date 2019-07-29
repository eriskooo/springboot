package sk.lorman.springboot.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sk.lorman.springboot.currencyexchangeservice.model.ExchangeValue;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable final String from, @PathVariable final String to) {
        ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, new BigDecimal(77));
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        logger.info("{}", exchangeValue);

        return exchangeValue;
    }
}
