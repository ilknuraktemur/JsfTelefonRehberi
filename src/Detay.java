import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import beans.Kisi;
import beans.Telefon;
import daoservice.Service;


@ManagedBean
@ViewScoped
	public class Detay{
	private int id;
	private String tel_no;
	private int phone_id;
	Service service=new Service();
	Kisi person=new Kisi();
	String hata_mesaji1;
	public Kisi getPerson() {
		return person;
	}

	public void setPerson(Kisi person) {
		this.person = person;
	}

	ArrayList<Telefon> phones=new ArrayList<Telefon>();
	
	@PostConstruct
	public void init() {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		id = Integer.parseInt(params.get("kisi_id"));
		System.out.println(id);
		try {
			person=service.kisibul_id(id);
			phones=service.telefonBul_Kid(id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public String getHata_mesaji1() {
		return hata_mesaji1;
	}

	public void setHata_mesaji1(String hata_mesaji1) {
		this.hata_mesaji1 = hata_mesaji1;
	}

	public void telefon_kaydet() {
	if(tel_no.length()!=17) {
		hata_mesaji1="Lütfen 11 haneli telefon numarasi giriniz";
	}
	else {
	hata_mesaji1="";
	Telefon phone=new Telefon();
	phone.setKisi_id(id);
	phone.setTelefon_no(tel_no);
	
	try {
		service.telefonKaydet(phone);
		phones=service.telefonBul_Kid(id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}}
	public void telefon_sil(Telefon telefon)
	{
	int telefon_id=telefon.getTel_id();
	try {
		service.telefonSil(telefon_id);
		phones=service.telefonBul_Kid(id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public ArrayList<Telefon> getPhones() {
		return phones;
	}

	public void setPhones(ArrayList<Telefon> phones) {
		this.phones = phones;
	}

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}

	public String getTel_no() {
		return tel_no;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	
	

}
