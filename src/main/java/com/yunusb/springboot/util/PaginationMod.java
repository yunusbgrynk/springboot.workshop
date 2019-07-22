package com.yunusb.springboot.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public class PaginationMod<T> {
  // page module to talk with service that we create
  private int number;
  private int size;
  private Sort sort;
  private int totalPages;
  private Long totalElements;
  private List<T> content;
  // calling the setvalue method creates an instance of the paginationModule object
  // filled our own object through Spring's Page
  public void setValue(Page page, List<T> list){
    this.number = page.getNumber();
    this.size = page.getSize();
    this.sort = page.getSort();
    this.totalPages = page.getTotalPages();
    this.totalElements = page.getTotalElements();
    this.content = list;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public Sort getSort() {
    return sort;
  }

  public void setSort(Sort sort) {
    this.sort = sort;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  public Long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Long totalElements) {
    this.totalElements = totalElements;
  }

  public List<T> getContent() {
    return content;
  }

  public void setContent(List<T> content) {
    this.content = content;
  }
}
