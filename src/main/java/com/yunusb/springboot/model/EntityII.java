package com.yunusb.springboot.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "entity_II")
public class EntityII extends BaseEntity {

  private Long id;
  private String description;
  private String details;
  private Date date;
  private Options options;
  private User userOfmodelII;
  private EntityI entityI;

  public EntityII(){

  }

  public EntityII(Long id, String description, String details, Date date, Options options) {
    this.id = id;
    this.description = description;
    this.details = details;
    this.date = date;
    this.options = options;
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
  @Column(name = "description",length = 1000)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Basic
  @Column(name = "details", length = 4000)
  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  @Basic
  @Column(name = "date")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Basic
  @Column(name = "entityII_options")
  @Enumerated(EnumType.STRING)
  public Options getOptions() {
    return options;
  }

  public void setOptions(Options options) {
    this.options = options;
  }

  @JoinColumn(name = "id_of_userEntityII")
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  public User getUserOfmodelII() {
    return userOfmodelII;
  }

  public void setUserOfmodelII(User userOfmodelII) {
    this.userOfmodelII = userOfmodelII;
  }

  @JoinColumn(name = "id_of_entityI")
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  public EntityI getEntityI() {
    return entityI;
  }

  public void setEntityI(EntityI entityI) {
    this.entityI = entityI;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EntityII entityII = (EntityII) o;
    return Objects.equals(id, entityII.id) &&
        Objects.equals(description, entityII.description) &&
        Objects.equals(details, entityII.details) &&
        Objects.equals(date, entityII.date) &&
        options == entityII.options;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, details, date, options);
  }
}
