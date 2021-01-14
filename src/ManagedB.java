import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.Kisi;
import daoservice.Service;


@ManagedBean(name="managedB")
@ViewScoped
public class ManagedB {
	public ManagedB() {
		super();
	}
	private String isim;
	private String soyisim;
	private String tc;
	private String hata_mesaji2;
	private String hata_mesaji3;

	

	
	public String getHata_mesaji2() {
		return hata_mesaji2;
	}
	public void setHata_mesaji2(String hata_mesaji2) {
		this.hata_mesaji2 = hata_mesaji2;
	}
	List<Kisi>sorgusonucu;
	Service service=new Service();
	

	public String gorunurlugu_degistir(Kisi x) {
		x.setGorunurluk(true);
		return null;
		
	}
	public String gorunurlugu_degistir2(Kisi x) throws SQLException {
		service.kisi_kaydet(x);
		x.setGorunurluk(false);
		
		return null;
		
	}
	
	public void kisi_guncelle(Kisi x) throws SQLException {
		if(x.getAd()!="" &&x.getSoyad()!="" && x.getTc()!="") {
		if(x.getTc().length()!=11) {
		hata_mesaji2="";
		hata_mesaji3="11 haneli tc kimlik numarasý giriniz";
		}
		else {
			hata_mesaji2="";
			hata_mesaji3="";
		service.kaydiGuncelle(x);
		sorgusonucu= service.kisibul(new Kisi());}
		
		
		
	}
	else {
		hata_mesaji3="";
		hata_mesaji2="Lütfen tüm alanlarý eksiksiz doldurun.";
	}}
public List<Kisi> getSorgusonucu() {
		return sorgusonucu;
	}
	public void setSorgusonucu(List<Kisi> sorgusonucu) {
		this.sorgusonucu = sorgusonucu;
	}
	
	@PostConstruct
	public void init() {
		sorgusonucu = new ArrayList<Kisi>();
	}
	

public ArrayList<Kisi> kisiBul() throws SQLException {
	Kisi x=new Kisi();
	sorgusonucu=new ArrayList<Kisi>();
	x.setAd(isim);
	x.setSoyad(soyisim);
	x.setTc(tc);
	
	sorgusonucu= service.kisibul(x);
	
	
	return (ArrayList<Kisi>) sorgusonucu;
	
}

public String kisiKaydet() throws SQLException {
	String message;
	if(isim=="" || soyisim=="" || tc=="" ) {
		hata_mesaji3="";
		hata_mesaji2="Lütfen tüm alanlari eksiksiz doldurunuz.";
		message="Kayit eklenemedi.";
		return message;
	}
	else {
		if(tc.length()!=11) {
			hata_mesaji2="";
		hata_mesaji3="11 haneli tc kimlik numarasý giriniz";
		message="Kayit eklenemedi.";
		return message;
		}
		else {
	hata_mesaji2="";
	hata_mesaji3="";
	Kisi x=new Kisi();
	
	x.setAd(isim);
	x.setSoyad(soyisim);
	x.setTc(tc);
	service.kisi_kaydet(x);
	message="Kayit basariyla eklendi.";
	
	sorgusonucu= service.kisibul(new Kisi());
	
	
	return message;
	
}}}
public String getHata_mesaji3() {
	return hata_mesaji3;
}
public void setHata_mesaji3(String hata_mesaji3) {
	this.hata_mesaji3 = hata_mesaji3;
}
public String kisi_Sil(Kisi kisi) throws SQLException

{ 
	service.kisi_sil(kisi);
	
	sorgusonucu= service.kisibul(new Kisi());
	return null;
	
	
	
}


public String redirectDetay(Kisi kisi) {
	return "detay.xhtml?faces-redirect=true&kisi_id=" + kisi.getId();
}

public ManagedB(String isim, String soyisim, String tc, boolean showtable, List<Kisi> sorgusonucu, Service service) {
	super();
	this.isim = isim;
	this.soyisim = soyisim;
	this.tc = tc;
	
	this.sorgusonucu = sorgusonucu;
	this.service = service;
}
public String getIsim() {
	return isim;
}
public void setIsim(String isim) {
	this.isim = isim;
}
public String getSoyisim() {
	return soyisim;
}
public void setSoyisim(String soyisim) {
	this.soyisim = soyisim;
}

public String getTc() {
	return tc;
}
public void setTc(String tc) {
	this.tc = tc;
}

public void mesaj() {
    FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage("Kayit basariyla eklendi. "));
}
}
