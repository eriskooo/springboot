package sk.lorman.springboot.currencyexchangeservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.lorman.springboot.currencyexchangeservice.model.ExchangeValue;

@Repository
public interface CurrencyExchangeRepository extends CrudRepository<ExchangeValue, Long> {
}
