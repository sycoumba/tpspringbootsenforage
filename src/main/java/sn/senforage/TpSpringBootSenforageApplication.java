package sn.senforage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import sn.senforage.dao.IUser;
import sn.senforage.dao.IVillage;
import sn.senforage.entities.User;
import sn.senforage.entities.Village;

@SpringBootApplication
public class TpSpringBootSenforageApplication {

	public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(TpSpringBootSenforageApplication.class, args);
	/*IUser iUser =ctx.getBean(IUser.class);
	User user = new User();
	user.setId(1);
	user.setNom("SY");  
	user.setPrenom("Coumba");
	user.setEmail("sycoumba193@gmail.com");
	user.setPassword("passer");
	try {
		iUser.save(user);
		System.out.println("ok");
	} catch (Exception e) {
		e.printStackTrace();
	}
	*/
	/*IVillage iVillage =ctx.getBean(IVillage.class);
	Village village = new Village();
	village.setId(1);
	village.setNom("Cascas");
	
	try {
		iVillage.save(village);
		System.out.println("ok");
	} catch (Exception e) {
		e.printStackTrace();
	}*/
	}

}
