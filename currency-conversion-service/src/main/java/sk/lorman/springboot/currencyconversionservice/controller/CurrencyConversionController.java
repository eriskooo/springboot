package sk.lorman.springboot.currencyconversionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDTO convertCurrency(@PathVariable final String from, @PathVariable final String to, @PathVariable final BigDecimal quantity) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionDTO> entity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionDTO.class, uriVariables);

        CurrencyConversionDTO response = entity.getBody();

        return new CurrencyConversionDTO(response.getId(), response.getFrom(), response.getTo(), response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}
