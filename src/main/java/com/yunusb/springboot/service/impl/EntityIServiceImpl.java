package com.yunusb.springboot.service.impl;

import com.yunusb.springboot.dto.EntityIDto;
import com.yunusb.springboot.model.EntityI;
import com.yunusb.springboot.repository.EntityIRepository;
import com.yunusb.springboot.repository.UserRepository;
import com.yunusb.springboot.service.EntityIService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    return null;
  }

  @Override
  public List<EntityI> getByEnt1codeContains(String ent1code) {
    return null;
  }
}
