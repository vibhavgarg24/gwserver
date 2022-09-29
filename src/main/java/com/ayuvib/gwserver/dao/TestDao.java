package com.ayuvib.gwserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayuvib.gwserver.model.Test;

public interface TestDao extends JpaRepository<Test, Integer> {

}
