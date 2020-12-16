package com.vw.restaurante.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.vw.restaurante.Entity.Productos;

public interface Interface_Productos extends JpaRepository<Productos, Integer> {
   @Query("select p from Productos p where p.IdCategoria_FK.id = :IdCategoria_FK")
	public List <Productos> findByCategoria(Integer IdCategoria_FK);
   @Query("select p from Productos p where p.IdProductos = :IdPro")
	public List <Productos> findByIdP(Integer IdPro);
}
