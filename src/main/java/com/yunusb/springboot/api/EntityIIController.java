package com.yunusb.springboot.api;

import com.yunusb.springboot.service.impl.EntityIIServiceImpl;
import com.yunusb.springboot.util.ApiPaths;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPaths.EntityII.BPA)
@Api(value = ApiPaths.EntityII.BPA, description = "Api's EntityII")
public class EntityIIController {

  private final EntityIIServiceImpl entityIIServiceImpl;

  @Autowired
  public EntityIIController(EntityIIServiceImpl entityIIServiceImpl) {
    this.entityIIServiceImpl = entityIIServiceImpl;
  }
}
