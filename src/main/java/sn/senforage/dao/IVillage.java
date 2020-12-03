package sn.senforage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import sn.senforage.entities.Village;


@Repository
public interface IVillage extends JpaRepository<Village, Integer>{
	
}
