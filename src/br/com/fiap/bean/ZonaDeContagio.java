package br.com.fiap.bean;

import java.sql.Date;

public class ZonaDeContagio {
  
  private int cd_zona;

  private String area_contagio;

  private Date dt_contagio;

  public ZonaDeContagio (int cd_zona, String area_contagio, Date dt_contagio){
      super();
      this.cd_zona = cd_zona;
      this.area_contagio = area_contagio;
      this.dt_contagio = dt_contagio;
  }

  public ZonaDeContagio() {
      super();
  }

  public int getCd_zona() {
      return cd_zona;
  }

  public void setCd_zona(int cd_zona) {
      this.cd_zona = cd_zona;
  }

  public String getArea_contagio() {
      return area_contagio;
  }

  public void setArea_contagio(String area_contagio) {
      this.area_contagio = area_contagio;
  }

  public Date getDt_contagio() {
      return dt_contagio;
  }

  public void setDt_contagio(Date dt_contagio) {
      this.dt_contagio = dt_contagio;
  }
}
