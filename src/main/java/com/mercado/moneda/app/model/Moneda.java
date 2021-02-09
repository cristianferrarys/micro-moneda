package com.mercado.moneda.app.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "monedas")
public class Moneda implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Boolean success;
  private String base;
  private String date;
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "moneda_id")
  private List<Rates> rates;
  private static final long serialVersionUID = 1L;

  public void setRates(Map<String, Double> rates) {
    List<Rates> listRates = new ArrayList<>();
    for (Entry<String, Double> val : rates.entrySet()) {
      Rates rateValue = new Rates();
      rateValue.setRatesKey(val.getKey());
      rateValue.setRate(val.getValue());
      listRates.add(rateValue);
    }
    this.rates = listRates;
  }

}
