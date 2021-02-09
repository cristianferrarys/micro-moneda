package com.mercado.moneda.app.serviceImpl;

import com.mercado.moneda.app.dto.MonedaDto;
import com.mercado.moneda.app.repository.MonedaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonedaRepositoryService {

  @Autowired
  private MonedaRepository repo;

  public List<MonedaDto> getFindByFechaMoneda(final String date, final String base, final String moneda) {
    List<MonedaDto> monedaDto = repo.getFechaMoneda(date, base, moneda);
    return monedaDto;
  }

}
