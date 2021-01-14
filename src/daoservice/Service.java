package daoservice;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Kisi;
import beans.Telefon;
import connect.DbConnectionnn;

public class Service implements IService {
	public Kisi kisi_kaydet(Kisi x)throws SQLException {
		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();
		System.out.println("Kaydetmeye baslandi.:\n");
		String sql_sorgu;
		String ad, soyad, tc;
		int id = x.getId();
		ad = x.getAd();
		soyad = x.getSoyad();
		tc = x.getTc();
		
		sql_sorgu = "insert into kisi (kisiAd, kisiSoyad,Tc) values ('"+ad+"','"+soyad+"','"+tc+"');";
		Statement statement = con.createStatement();
		statement.executeUpdate(sql_sorgu);
		
		dbConnectionnn.closeDatabase(con);
		System.out.println("Kisi baþarýyla eklendi.");
		
		return x;
	}
	public void kaydiGuncelle(Kisi k) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 connection = DriverManager.getConnection(
						"jdbc:sqlserver://localhost:1433;databaseName=TelefonRehberi;integratedSecurity=true;",
						"DESKTOP-5JV4MDV\\q", "");
			 preparedStatement=connection.prepareStatement("update kisi set kisiAd=?,kisiSoyad=?,Tc=? where [kisi-ID]=?");
			
			
			 preparedStatement.setString(1,k.getAd());
			 preparedStatement.setString(2,k.getSoyad());
			 preparedStatement.setString(3,k.getTc());
			 preparedStatement.setInt(4,k.getId());
			 preparedStatement.executeUpdate();
			 
			 }
		
			 catch(Exception e){
					System.err.println("Hata meydana geldi"+e);
					
				}
				finally {
					try {
						connection.close();
						preparedStatement.close();
						
					}
					catch(Exception e) {
					 
						System.out.println("Hata"+e);
					
					
				}
				}}
	public void kisi_sil(Kisi x) throws SQLException {
		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();
		String sql_sorgu;
		int kisi_id=x.getId();
		sql_sorgu = "delete from Kisi where Kisi.[Kisi-ID]=" + "'" + kisi_id + "'";
		Statement statement = con.createStatement();
		statement.executeUpdate(sql_sorgu);

		dbConnectionnn.closeDatabase(con);
		System.out.println("Kiþi baþarýyla silindi");

	}
	
	
	
	
	
	public Kisi kisibul_id(int id) throws SQLException {

		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();
		System.out.println("Bulunan kayýtlar:\n");

		String sql_sorgu;
		int p_id;
		p_id = id;
		sql_sorgu = "select * from kisi where kisi.[Kisi-ID]=" + "'" + p_id + "'";
		Statement statement = con.createStatement();
		statement.executeQuery(sql_sorgu);

		ResultSet resultQuery = statement.executeQuery(sql_sorgu);
		Kisi kisi = new Kisi();

		while (resultQuery.next()) {

			kisi.setAd(resultQuery.getString(1));
			kisi.setSoyad(resultQuery.getString(2));
			kisi.setTc(resultQuery.getString(3));
			kisi.setId(resultQuery.getInt(4));

		}

		dbConnectionnn.closeDatabase(con);
		return kisi;

	}

	public Telefon telefonbul_id(String id) throws SQLException {

		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();
		System.out.println("Bulunan kayýtlar:\n");

		String sql_sorgu, p_id;
		p_id = id;
		sql_sorgu = "select [Tel-ID],telNo from Telefon where [Tel-ID]=" + "'" + p_id + "'";
		Statement statement = con.createStatement();
		statement.executeQuery(sql_sorgu);

		ResultSet resultQuery = statement.executeQuery(sql_sorgu);
		Telefon telefon = new Telefon();
		while (resultQuery.next()) {
			telefon.setTel_id(resultQuery.getInt(1));
			telefon.setTelefon_no(resultQuery.getString(2));
		}

		dbConnectionnn.closeDatabase(con);
		return telefon;

	}

	public Telefon telefonbul_kid(int id) throws SQLException {

		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();
		System.out.println("Bulunan kayýtlar:\n");

		String sql_sorgu;
		int k_id;
		k_id = id;
		sql_sorgu = "select [Tel-ID],telNo,[kisi-ID] from Telefon where [Kisi-ID]=" + "'" + k_id + "'";
		Statement statement = con.createStatement();
		statement.executeQuery(sql_sorgu);

		ResultSet resultQuery = statement.executeQuery(sql_sorgu);
		Telefon telefon = new Telefon();
		while (resultQuery.next()) {
			telefon.setTel_id(resultQuery.getInt(1));
			telefon.setTelefon_no(resultQuery.getString(2));
			telefon.setKisi_id(resultQuery.getInt(3));
		}

		dbConnectionnn.closeDatabase(con);
		return telefon;

	}

	public void kisiKaydet(Kisi kisi) throws SQLException {

		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();

		String ad, soyad, tc, telId, sql_sorgu;
		int id = kisi.getId();
		ad = kisi.getAd();
		soyad = kisi.getSoyad();
		tc = kisi.getTc();
		telId = kisi.getTel_id();

		sql_sorgu = "INSERT INTO Kisi values(" + "'" + id + "'," + "'" + ad + "'," + "'" + soyad + "'," + "'" + tc
				+ "'," + "'" + telId + "')";
		Statement statement = con.createStatement();
		statement.executeUpdate(sql_sorgu);

		dbConnectionnn.closeDatabase(con);

		System.out.println("Kiþi baþarýyla eklendi.");

	}

	public void kisiSil(String id) throws SQLException {
		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();
		String sql_sorgu, id_no;
		id_no = id;
		sql_sorgu = "delete from Kisi where Kisi.[Kisi-ID]=" + "'" + id_no + "'";
		Statement statement = con.createStatement();
		statement.executeUpdate(sql_sorgu);

		dbConnectionnn.closeDatabase(con);
		System.out.println("Kiþi baþarýyla silindi");

	}

	public Telefon telefonKaydet(Telefon t1) throws SQLException {
		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();
		String no, sql_sorgu;
		int kisi_id=t1.getKisi_id();
		no = t1.getTelefon_no();
		System.out.println("kaydeilmeye baslanýyor\n");
		
		sql_sorgu = "INSERT INTO Telefon([kisi-ID],[telNo]) values(" + "'" + kisi_id + "'," + "'" + no + "'" + ")";

		Statement statement = con.createStatement();
		statement.executeUpdate(sql_sorgu);

		dbConnectionnn.closeDatabase(con);
		System.out.println("Telefon baþarýyla eklendi.");
		return t1;

	}

	public void telefonSil(int telID) throws SQLException {
		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();

		String sql_sorgu;
		int id_no = telID;
		sql_sorgu = "delete from Telefon where Telefon.[Tel-ID]=" + "'" + id_no + "'";
		Statement statement = con.createStatement();
		statement.executeUpdate(sql_sorgu);

		dbConnectionnn.closeDatabase(con);
		System.out.println("Telefon baþarýyla silindi");

	}

	public ArrayList<Telefon> telefonBul(String numara) throws SQLException {
		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();

		System.out.println("Bulunan kayýtlar:\n");

		String sql_sorgu, num;
		num = numara;
		sql_sorgu = "select telefon.[Tel-ID] ,Telefon.telNo from kisi inner join telefon on kisi.[tel-ID]=telefon.[Tel-ID]where telefon.telNo="
				+ "'" + num + "'";
		Statement statement = con.createStatement();
		statement.executeQuery(sql_sorgu);

		ResultSet resultQuery = statement.executeQuery(sql_sorgu);

		ArrayList<Telefon> list = new ArrayList<Telefon>();
		while (resultQuery.next()) {
			Telefon telefon = new Telefon();

			telefon.setTel_id(resultQuery.getInt(1));
			telefon.setTelefon_no(resultQuery.getString(2));

			list.add(telefon);

		}
		dbConnectionnn.closeDatabase(con);
		return list;
	}

	public ArrayList<Telefon> telefonBul_Kid(int kisi_id_int) throws SQLException {
		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();

		System.out.println("Bulunan kayýtlar:\n");

		String sql_sorgu;
		int kisi_id;
		kisi_id = kisi_id_int;
		sql_sorgu = "select*from telefon where [Kisi-ID]=" + "'" + kisi_id + "'";
		Statement statement = con.createStatement();
		statement.executeQuery(sql_sorgu);

		ResultSet resultQuery = statement.executeQuery(sql_sorgu);

		ArrayList<Telefon> list = new ArrayList<Telefon>();
		while (resultQuery.next()) {
			Telefon telefon = new Telefon();

			telefon.setKisi_id(resultQuery.getInt(1));
			telefon.setTelefon_no(resultQuery.getString(2));
			telefon.setTel_id(resultQuery.getInt(3));

			list.add(telefon);

		}
		dbConnectionnn.closeDatabase(con);
		return list;
	}

	public static void main(String[] args) {

	}

	public ArrayList<Kisi> KisiBul_isim(String name) throws SQLException {
		System.out.println("Bulunan kayýtlar:\n");
		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();

		String sql_sorgu, f_name;
		f_name = name;
		sql_sorgu = "select kisi.tc,kisi.kisiad,kisi.kisiSoyad,kisi.[Kisi-ID] from kisi where kisi.kisiAd=" + "'"
				+ f_name + "'";
		Statement statement = con.createStatement();
		statement.executeQuery(sql_sorgu);

		ResultSet resultQuery = statement.executeQuery(sql_sorgu);

		ArrayList<Kisi> list = new ArrayList<Kisi>();

		while (resultQuery.next()) {

			Kisi kisi = new Kisi();

			kisi.setTc(resultQuery.getString(1));
			kisi.setAd(resultQuery.getString(2));
			kisi.setSoyad(resultQuery.getString(3));
			kisi.setId(resultQuery.getInt(4));

			list.add(kisi);

		}
		dbConnectionnn.closeDatabase(con);
		return list;

	}

	public ArrayList<Kisi> KisiBul_soyisim(String sname) throws SQLException {
		System.out.println("Bulunan kayýtlar:\n");
		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();

		String sql_sorgu, s_name;
		s_name = sname;
		sql_sorgu = "select kisi.tc,kisi.kisiad,kisi.kisiSoyad,kisi.[Kisi-ID] from kisi where kisi.kisiSoyad=" + "'"
				+ s_name + "'";
		Statement statement = con.createStatement();
		statement.executeQuery(sql_sorgu);

		ResultSet resultQuery = statement.executeQuery(sql_sorgu);

		ArrayList<Kisi> list = new ArrayList<Kisi>();

		while (resultQuery.next()) {

			Kisi kisi = new Kisi();

			kisi.setTc(resultQuery.getString(1));
			kisi.setAd(resultQuery.getString(2));
			kisi.setSoyad(resultQuery.getString(3));
			kisi.setId(resultQuery.getInt(4));

			list.add(kisi);

		}
		dbConnectionnn.closeDatabase(con);
		return list;
	}

	public ArrayList<Kisi> kisibul(Kisi x) throws SQLException {
		
		DbConnectionnn dbConnectionnn = new DbConnectionnn();
		Connection con = dbConnectionnn.connectDatabase();
		System.out.println("Bulunan kayýtlar:\n");
		
		String sorgu = "select * from kisi where  1=1";
		
		if(x.getAd() != null && !"".equals(x.getAd())) {
			sorgu += " and kisi.[kisiAd]="+ "'" + x.getAd() + "'";
		}
        if(x.getSoyad() != null && !"".equals(x.getSoyad())) {
        	sorgu +=  " and kisi.[kisiSoyad]="+ "'" + x.getSoyad() + "'";
		}
        if(x.getTc() != null && !"".equals(x.getTc())) {
        	sorgu +=  " and kisi.[Tc]="+ "'" + x.getTc() + "'";
        }
				
		
		Statement statement = con.createStatement();
		statement.executeQuery(sorgu);
		
		ResultSet resultQuery = statement.executeQuery(sorgu);
		ArrayList<Kisi> list = new ArrayList<Kisi>();
		while (resultQuery.next()) {
			Kisi kisi = new Kisi();
			kisi.setAd(resultQuery.getString(1));
			kisi.setSoyad(resultQuery.getString(2));
			kisi.setTc(resultQuery.getString(3));
			kisi.setId(resultQuery.getInt(4));
			list.add(kisi);
		}
	
		dbConnectionnn.closeDatabase(con);
		return list ;

	}
}
