package com.mercado.moneda.app.serviceImpl;

import com.mercado.moneda.app.config.FixeConfig;
import com.mercado.moneda.app.model.Moneda;
import com.mercado.moneda.app.repository.MonedaRepository;
import com.mercado.moneda.app.service.MonedaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@Service
public class MonedaServicioImpl implements MonedaService {

  @Autowired
  private FixeConfig fixeConfig;
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private MonedaRepository repo;

  @Override
  public void getMonedaAll() {
    final URI targetUrl = UriComponentsBuilder.fromUriString(fixeConfig.getUrl()).path("/latest")
        .queryParam("access_key", fixeConfig.getAccess_key()).build().toUri();
    ResponseEntity<Moneda> result = restTemplate.getForEntity(targetUrl, Moneda.class);
    String dateNow = LocalDate.now().toString();
    Moneda moneda = repo.findByDate(dateNow);
    repo.delete(moneda);
    repo.save(result.getBody());
  }

}
