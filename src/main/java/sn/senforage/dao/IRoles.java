package sn.senforage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import sn.senforage.entities.Roles;

@Repository
public interface IRoles extends JpaRepository<Roles, Integer> {

}
