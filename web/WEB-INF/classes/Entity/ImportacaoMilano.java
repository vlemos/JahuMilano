package Entity;

import java.util.Date;

public class ImportacaoMilano
{
  private Integer codfil;
  private Date datemi;
  private String codsnf;
  private Integer numnfv;
  private String codcli;
  private String codpro;
  private String codder;
  private double qtdfat;
  private double preven;
  private String chvdoe;
  private String tnspro;
  private Integer seqipv;
  private Float vlrbpr;
  private String despro;
  private String desder;
  private String obs;
  private String codenq;
  private String codsel;
  
  public String getDespro()
  {
    return this.despro;
  }
  
  public void setDespro(String paramString)
  {
    this.despro = paramString;
  }
  
  public String getDesder()
  {
    return this.desder;
  }
  
  public void setDesder(String paramString)
  {
    this.desder = paramString;
  }
  
  public Float getVlrbpr()
  {
    return this.vlrbpr;
  }
  
  public void setVlrbpr(Float paramFloat)
  {
    this.vlrbpr = paramFloat;
  }
  
  public Integer getCodfil()
  {
    return this.codfil;
  }
  
  public void setCodfil(Integer paramInteger)
  {
    this.codfil = paramInteger;
  }
  
  public Date getDatemi()
  {
    return this.datemi;
  }
  
  public void setDatemi(Date paramDate)
  {
    this.datemi = paramDate;
  }
  
  public String getCodsnf()
  {
    return this.codsnf;
  }
  
  public void setCodsnf(String paramString)
  {
    this.codsnf = paramString;
  }
  
  public Integer getNumnfv()
  {
    return this.numnfv;
  }
  
  public void setNumnfv(Integer paramInteger)
  {
    this.numnfv = paramInteger;
  }
  
  public String getCodcli()
  {
    return this.codcli;
  }
  
  public void setCodcli(String paramString)
  {
    this.codcli = paramString;
  }
  
  public String getCodpro()
  {
    return this.codpro;
  }
  
  public void setCodpro(String paramString)
  {
    this.codpro = paramString;
  }
  
  public String getCodder()
  {
    return this.codder;
  }
  
  public void setCodder(String paramString)
  {
    this.codder = paramString;
  }
  
  public double getQtdfat()
  {
    return this.qtdfat;
  }
  
  public void setQtdfat(double paramDouble)
  {
    this.qtdfat = paramDouble;
  }
  
  public double getPreven()
  {
    return this.preven;
  }
  
  public void setPreven(double paramDouble)
  {
    this.preven = paramDouble;
  }
  
  public String getChvdoe()
  {
    return this.chvdoe;
  }
  
  public void setChvdoe(String paramString)
  {
    this.chvdoe = paramString;
  }
  
  public String getTnspro()
  {
    return this.tnspro;
  }
  
  public void setTnspro(String paramString)
  {
    this.tnspro = paramString;
  }
  
  public Integer getSeqipv()
  {
    return this.seqipv;
  }
  
  public void setSeqipv(Integer paramInteger)
  {
    this.seqipv = paramInteger;
  }
  
  public String toString()
  {
    return "ImportacaoJahu [codfil=" + this.codfil + ", datemi=" + this.datemi + ", codsnf=" + this.codsnf + ", numnfv=" + this.numnfv + ", codcli=" + this.codcli + ", codpro=" + this.codpro + ", codder=" + this.codder + ", qtdfat=" + this.qtdfat + ", preven=" + this.preven + ", chvdoe=" + this.chvdoe + ", tnspro=" + this.tnspro + ", seqipv=" + this.seqipv + ", VLRBPR=" + this.vlrbpr + ", despro=" + this.despro + ", desder=" + this.desder + "]";
  }
  
  public String getObs()
  {
    return this.obs;
  }
  
  public void setObs(String paramString)
  {
    this.obs = paramString;
  }
  
  public String getCodenq()
  {
    return this.codenq;
  }
  
  public void setCodenq(String paramString)
  {
    this.codenq = paramString;
  }
  
  public String getCodsel()
  {
    return this.codsel;
  }
  
  public void setCodsel(String paramString)
  {
    this.codsel = paramString;
  }
}
