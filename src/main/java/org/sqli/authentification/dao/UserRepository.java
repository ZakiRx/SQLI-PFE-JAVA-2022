package org.sqli.authentification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sqli.authentification.entitie.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
