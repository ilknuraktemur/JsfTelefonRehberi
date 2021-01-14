package beans;



public class Kisi {
	private int id;
	private String ad;
	private String soyad;
	private String tc;
	private String tel_id;
	private boolean gorunurluk;

	public boolean isGorunurluk() {
		return gorunurluk;
	}

	public void setGorunurluk(boolean gorunurluk) {
		this.gorunurluk = gorunurluk;
	}

	public String getAd() {
		return ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getTel_id() {
		return tel_id;
	}

	public void setTel_id(String tel_id) {
		this.tel_id = tel_id;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}
	
	
}
