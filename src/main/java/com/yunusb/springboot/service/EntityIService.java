package com.yunusb.springboot.service;

import com.yunusb.springboot.dto.EntityIDto;
import com.yunusb.springboot.model.EntityI;
import com.yunusb.springboot.util.PaginationMod;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EntityIService {

  EntityIDto save(EntityIDto entityIDto);
  EntityIDto getById(Long id);
  EntityIDto getByEnt1code(String ent1code);
  List<EntityI> getByEnt1codeContains(String ent1code);
  Boolean delete(Long id);
  PaginationMod<EntityIDto> getAllPageable(Pageable pageable);
  EntityIDto update(Long id, EntityIDto entityIDto);

}
