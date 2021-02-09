package com.mercado.moneda.app.controller;

import com.mercado.moneda.app.dto.MonedaDto;
import com.mercado.moneda.app.serviceImpl.MonedaRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonedaController {

  @Autowired
  private MonedaRepositoryService monedaRepoServicio;

  @GetMapping("/moneda")
  public ResponseEntity<?> getFechaMoneda(@RequestParam(name = "fecha", defaultValue = "NA") String fecha,
      @RequestParam(name = "monedaOrigen", defaultValue = "EUR") String monedaOrigen,
      @RequestParam(name = "moneda", defaultValue = "EUR") String moneda) {
    if (fecha.equals("NA")) {
      return new ResponseEntity<>("ingrese fecha", HttpStatus.BAD_REQUEST);
    }
    List<MonedaDto> m = monedaRepoServicio.getFindByFechaMoneda(fecha, monedaOrigen, moneda);
    return new ResponseEntity<>(m, HttpStatus.OK);
  }


}
