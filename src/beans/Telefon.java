package beans;




public class Telefon {
	private int  tel_id;
	private String telefon_no;
	private int kisi_id;

	public int getKisi_id() {
		return kisi_id;
	}

	public void setKisi_id(int kisi_id) {
		this.kisi_id = kisi_id;
	}

	public int  getTel_id() {
		return tel_id;
	}

	public void setTel_id(int tel_id) {
		this.tel_id = tel_id;
	}

	

	public Telefon(String telefon_no) {
		super();
		this.telefon_no = telefon_no;
	}

	public Telefon() {

	}

	public String getTelefon_no() {
		return telefon_no;
	}

	public void setTelefon_no(String telefon_no) {
		this.telefon_no = telefon_no;
	}

}
