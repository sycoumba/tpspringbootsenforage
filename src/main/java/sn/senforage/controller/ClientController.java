package sn.senforage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sn.senforage.dao.IClient;
import sn.senforage.dao.IUser;
import sn.senforage.dao.IVillage;
import sn.senforage.entities.Client;
import sn.senforage.entities.User;
import sn.senforage.entities.Village;


@Controller
public class ClientController {
	
	@Autowired	
	private IClient clientdao;
	@Autowired
	private IVillage villagedao;
	@Autowired
	private IUser userdao;	
	@RequestMapping(value ="Client/liste")
public String list(ModelMap model){
		List<Client> clients = clientdao.findAll();
		List<Village> villages = villagedao.findAll();
		List<User> users = userdao.findAll();
		
		model.put("liste_clients", clients);
		model.put("liste_villages", villages);
		model.put("liste_users", users);
	return ("client/listec");
	
}
	@RequestMapping(value ="Client/add", method=RequestMethod.POST)
	public String add(String nom,String prenom,String telephone,String adresse,int idVillage, int idUser) {
		ModelAndView modelAndView = new ModelAndView();
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setTelephone(telephone);
		client.setAdresse(adresse);
		
		User user= new User();
		user =userdao.getOne(idUser);
		
		Village village = new Village();
		village =villagedao.getOne(idVillage);
		
		client.setUser(user);
		client.setVillage(village);
		try {
		clientdao.save(client);
		modelAndView.addObject("result",new String("Données ajoutées"));
		}catch(Exception ex) 
		{
			modelAndView.addObject("result",new String("Données non ajoutées"));
		}
		modelAndView.addObject(new String("client/listec"));
		
        return "redirect:/Client/liste";
	}
	@RequestMapping(value = "Client/delete",method = RequestMethod.GET)

	public String delete(int id) {
		try {
		clientdao.delete(clientdao.getOne(id));
		clientdao.flush();
		}catch(Exception e) 	{
			e.printStackTrace();
			
		}

		return "redirect:Client/liste";
}
	}
