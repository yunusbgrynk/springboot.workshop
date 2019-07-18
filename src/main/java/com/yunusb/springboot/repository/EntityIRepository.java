package com.yunusb.springboot.repository;

import com.yunusb.springboot.model.EntityI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface EntityIRepository extends JpaRepository<EntityI, Long> {

  EntityI getByEnt1code(String ent1code);
  List<EntityI> getByEnt1codeContains(String ent1code);
  Page<EntityI> findAll(Pageable pageable);
  List<EntityI> findAll(Sort sort);
  EntityI getByEnt1codeAndIdNot(String ent1code, Long id);

}
