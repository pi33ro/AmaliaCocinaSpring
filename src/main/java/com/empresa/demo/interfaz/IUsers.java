package com.empresa.demo.interfaz;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.demo.model.Users;

public interface IUsers extends JpaRepository<Users, Integer>{

}
