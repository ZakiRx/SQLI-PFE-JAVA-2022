package org.sqli.authentification.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.sqli.authentification.entitie.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByLoginAndPassword(String login,String password);
    User findByLogin(String login);

}
