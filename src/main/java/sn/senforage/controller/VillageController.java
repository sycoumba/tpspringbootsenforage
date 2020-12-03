package sn.senforage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sn.senforage.dao.IUser;
import sn.senforage.dao.IVillage;
import sn.senforage.entities.User;
import sn.senforage.entities.Village;

@Controller
public class VillageController {

@Autowired
private IVillage villagedao;
@Autowired
private IUser userdao;	
@RequestMapping(value = "/Village/liste")
public String list(ModelMap model) {
	List<Village> villages = villagedao.findAll();
	List<User> users = userdao.findAll();
	
	model.put("liste_villages", villages);
	model.put("liste_users", users);
return ("village/listev");
}
@RequestMapping(value="Village/add",method=RequestMethod.POST)
public String  add(String nom, int idUser){
ModelAndView modelAndView = new ModelAndView();
Village village = new Village();
village.setNom(nom);
User user= new User();
user =userdao.getOne(idUser);
village.setUser(user);
try {
	villagedao.save(village);
	modelAndView.addObject("result",new String("Données ajoutées"));
	
	}catch(Exception ex) 
	{
		modelAndView.addObject("result",new String("Données non ajoutées"));
	}
	modelAndView.addObject(new String("village/listev"));
	
    return "redirect:/Village/liste";
}
@RequestMapping(value = "Village/delete",method = RequestMethod.GET)

public String delete(int id) {
	try {
	villagedao.delete(villagedao.getOne(id));
	}catch(Exception e) 	{
		e.printStackTrace();
		
	}

	return "redirect:Village/liste";
}
}
