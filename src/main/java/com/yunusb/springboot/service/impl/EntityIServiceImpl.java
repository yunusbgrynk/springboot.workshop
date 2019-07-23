package com.yunusb.springboot.service.impl;

import com.yunusb.springboot.dto.EntityIDto;
import com.yunusb.springboot.model.EntityI;
import com.yunusb.springboot.repository.EntityIRepository;
import com.yunusb.springboot.repository.UserRepository;
import com.yunusb.springboot.service.EntityIService;
import com.yunusb.springboot.util.PaginationMod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EntityIServiceImpl implements EntityIService {

  private final EntityIRepository entityIRepository;
  private final ModelMapper modelMapper;
  private final UserRepository userRepository;

  @Autowired
  public EntityIServiceImpl(EntityIRepository entityIRepository, ModelMapper modelMapper, UserRepository userRepository) {
    this.entityIRepository = entityIRepository;
    this.modelMapper = modelMapper;
    this.userRepository = userRepository;
  }

  @Override
  public EntityIDto save(EntityIDto entityIDto) {
    if (entityIDto.getEnt1code() == null){
      throw new IllegalArgumentException("EntityI code cannot be null");
    }
    EntityI entityITest = entityIRepository.getByEnt1code(entityIDto.getEnt1code());
    if (entityITest != null){
      throw new IllegalArgumentException("EntityI Code Already Exist");
    }
    EntityI entityI = modelMapper.map(entityIDto, EntityI.class);
    entityI = entityIRepository.save(entityI);
    entityIDto.setId(entityI.getId());
    return entityIDto;
  }

  @Override
  public EntityIDto getById(Long id) {
    EntityI entityI = entityIRepository.getOne(id);
    return modelMapper.map(entityI, EntityIDto.class);
  }

  @Override
  public EntityIDto getByEnt1code(String ent1code) {
    EntityI getByCodeEntity = entityIRepository.getByEnt1code(ent1code);
    return modelMapper.map(getByCodeEntity, EntityIDto.class);
  }

  @Override
  public List<EntityI> getByEnt1codeContains(String ent1code) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    entityIRepository.deleteById(id);
    return true;
  }

  @Override
  public PaginationMod<EntityIDto> getAllPageable(Pageable pageable) {
    Page<EntityI> pagesOfentityI = entityIRepository.findAll(pageable);
    PaginationMod paginationMod = new PaginationMod<EntityIDto>(); //response of Pagination request
    EntityIDto[] entityIDtos = modelMapper.map(pagesOfentityI.getContent(),EntityIDto[].class);
    paginationMod.setValue(pagesOfentityI, Arrays.asList(entityIDtos));
    return paginationMod;
  }

  @Override
  public EntityIDto update(Long id, EntityIDto entityIDto) {
    EntityI entityI =entityIRepository.getOne(id);
    if (entityI == null){
      throw new IllegalArgumentException("Not found updated entity1");
    }
    EntityI entityI1Control = entityIRepository.getByEnt1codeAndIdNot(entityIDto.getEnt1code(), id);
    if(entityI1Control != null){
      throw new IllegalArgumentException("This entity code already exist");
    }
    entityI.setEnt1code(entityIDto.getEnt1code());
    entityI.setEnt1name(entityIDto.getEnt1name());
    entityIRepository.save(entityI);
    return modelMapper.map(entityI, EntityIDto.class);
  }
}
