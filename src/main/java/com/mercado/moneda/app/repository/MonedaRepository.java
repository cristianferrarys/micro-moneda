package com.mercado.moneda.app.repository;

import com.mercado.moneda.app.dto.MonedaDto;
import com.mercado.moneda.app.model.Moneda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Long> {
  @Query(
      value = "SELECT new com.mercado.moneda.app.dto.MonedaDto(r.ratesKey , r.rate) FROM Moneda m INNER JOIN m.rates r WHERE m.date= :date and m.base= :base  and r.ratesKey= :moneda ")
  List<MonedaDto> getFechaMoneda(@Param("date") String date, @Param("base") String base, @Param("moneda") String moneda);

  Moneda findByDate(String date);
}
