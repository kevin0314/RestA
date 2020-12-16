package com.vw.restaurante.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vw.restaurante.Entity.Detalle_Orden;

public interface Interface_Detalle extends JpaRepository<Detalle_Orden,Integer> {

}
