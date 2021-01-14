package daoservice;


import java.sql.SQLException;
import java.util.ArrayList;

import beans.Kisi;
import beans.Telefon;

public interface IService {
	void kisiKaydet(Kisi kisi) throws SQLException;

	void kisiSil(String id) throws SQLException;

	Telefon telefonKaydet(Telefon t1) throws SQLException;

	void telefonSil(int telID) throws SQLException;

	ArrayList<Kisi>  KisiBul_isim(String name) throws SQLException;

	ArrayList<Telefon> telefonBul(String a) throws SQLException;
	ArrayList<Telefon> telefonBul_Kid(int a) throws SQLException;

	ArrayList<Kisi> KisiBul_soyisim(String surname) throws SQLException;
	Kisi kisibul_id(int id) throws SQLException;
	Telefon telefonbul_id(String id)  throws SQLException;
	Telefon telefonbul_kid(int id)  throws SQLException;
	

}
