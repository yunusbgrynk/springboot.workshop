package com.yunusb.springboot.api;

import com.yunusb.springboot.dto.EntityIDto;
import com.yunusb.springboot.service.impl.EntityIServiceImpl;
import com.yunusb.springboot.util.ApiPaths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.EntityI.BPA)
@Slf4j
public class EntityIController {

  private final EntityIServiceImpl entityIService;

  @Autowired
  public EntityIController(EntityIServiceImpl entityIService) {
    this.entityIService = entityIService;
  }

 // @PostMapping
  @RequestMapping(value = "/createEntityI", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EntityIDto> saveEntityI(@Valid @RequestBody EntityIDto entityIDto){
    return ResponseEntity.ok(entityIService.save(entityIDto));
  }

 // @GetMapping("/{id}")
  @RequestMapping(value = "/getEntityI/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EntityIDto> getById(@PathVariable(value = "id",required = true) Long id){
    log.info("Initializing entityIServiceImpl :"+EntityIServiceImpl.class);
    EntityIDto entityIDto = entityIService.getById(id);
    return ResponseEntity.ok(entityIDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
    log.info("Deleting this id : "+id);
    return ResponseEntity.ok(entityIService.delete(id));
  }

}
