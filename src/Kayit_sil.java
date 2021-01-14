import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import beans.Kisi;
import daoservice.Service;

@ManagedBean
@RequestScoped
public class Kayit_sil {
	public boolean kisi_Sil(Kisi x) throws SQLException

	{ Service service=new Service();
		service.kisi_sil(x);
		return true;
		
		
	}
}
