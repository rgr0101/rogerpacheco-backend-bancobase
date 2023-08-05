//Bootcamp Desarrollo de Aplicaciones de Banca | Banco BASE
//Hecho por: Roger Pacheco

package com.bancobase.bootcamp.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancobase.bootcamp.dto.CurrencyDTO;
import com.bancobase.bootcamp.dto.response.ExchangeRateResponse;
import com.bancobase.bootcamp.dto.response.Symbol;
import com.bancobase.bootcamp.dto.response.SymbolsNameResponse;
import com.bancobase.bootcamp.http.APIExchangeRateClient;

@RestController
public class CurrencyService {

    private final APIExchangeRateClient exchangeRateClient;

    public CurrencyService(APIExchangeRateClient exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }

    @GetMapping("currency")
    public List<CurrencyDTO> getAllCuzrrencies() {

        ExchangeRateResponse exchangeRateResponse = exchangeRateClient.getExchangeRate();
        SymbolsNameResponse symbolsNameResponse = exchangeRateClient.getSymbolsName();

        List<CurrencyDTO> currenciesList = new ArrayList<>(); //lista para currencies

        //reorremos y alamcenamos en la list
        for (String symbol : exchangeRateResponse.getRates().keySet()) {
            Symbol symbolObjeto = symbolsNameResponse.getSymbols().get(symbol);
            Double value = exchangeRateResponse.getRates().get(symbol);
            
            CurrencyDTO currencies = new CurrencyDTO();
            currencies.setSymbol(symbol);
            currencies.setName((symbolObjeto != null) ? symbolObjeto.getDescription() : null);
            currencies.setValue(value);

            currenciesList.add(currencies);
        }

        //retornamos la list
        return currenciesList;
    }
    
}
