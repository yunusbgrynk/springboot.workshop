package com.yunusb.springboot.repository;

import com.yunusb.springboot.model.EntityIIDetail;
import org.springframework.data.jpa.repository.JpaRepository;
//Spring Data
public interface EntityIIHistoryRepository extends JpaRepository<EntityIIDetail, Long> {
}
