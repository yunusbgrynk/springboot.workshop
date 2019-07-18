package com.yunusb.springboot.model;

import javax.persistence.*;
import java.util.Objects;

//Data model
@Entity
@Table(name = "entity_1")
public class EntityI extends BaseEntity {

  private Long id;
  private String ent1name;
  private String ent1code;
  private User aheaedUser;

  public EntityI (){

  }

  public EntityI(Long id, String ent1name, String ent1code) {
    this.id = id;
    this.ent1name = ent1name;
    this.ent1code = ent1code;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Basic
  @Column(name = "entity1_name")
  public String getEnt1name() {
    return ent1name;
  }

  public void setEnt1name(String ent1name) {
    this.ent1name = ent1name;
  }

  @Basic
  @Column(name = "entity1_code")
  public String getEnt1code() {
    return ent1code;
  }

  public void setEnt1code(String ent1code) {
    this.ent1code = ent1code;
  }

  @JoinColumn(name = "ahead_user_id")
  @ManyToOne(optional = true , fetch = FetchType.LAZY)
  public User getAheaedUser() {
    return aheaedUser;
  }

  public void setAheaedUser(User aheaedUser) {
    this.aheaedUser = aheaedUser;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EntityI entityI = (EntityI) o;
    return Objects.equals(id, entityI.id) &&
        Objects.equals(ent1name, entityI.ent1name) &&
        Objects.equals(ent1code, entityI.ent1code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ent1name, ent1code);
  }
}
