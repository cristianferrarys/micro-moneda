package com.mercado.moneda.app.task;

import com.mercado.moneda.app.service.MonedaService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CargaTask {

  @Autowired
  private MonedaService monedaServicio;

  @Scheduled(cron = "0 05 10 * * *")
  public void cargarDbMoneda() {
    try {
      monedaServicio.getMonedaAll();
      log.info("Se carga de datos a las 10:05 todo los dias ");
    } catch (final Exception ex) {
      log.error("Error en la carga de la db ", ex);
    }
  }
  
}
