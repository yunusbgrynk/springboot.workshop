package com.yunusb.springboot.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "history_of_entityII")
public class EntityIIDetail {

  private Long id;
  private EntityII entityII;
  private String description;
  private Date date;
  private Options options;
  private String detail;
  private User user;

  public EntityIIDetail() {

  }

  public EntityIIDetail(Long id, String description, Date date, Options options, String detail) {
    this.id = id;
    this.description = description;
    this.date = date;
    this.options = options;
    this.detail = detail;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @JoinColumn(name = "id_of_entityII")
  @ManyToOne(optional = true,fetch = FetchType.LAZY)
  public EntityII getEntityII() {
    return entityII;
  }

  public void setEntityII(EntityII entityII) {
    this.entityII = entityII;
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
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "date")
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

  @Basic
  @Column(name = "details", length = 4000)
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  @JoinColumn(name = "user_of_entityII")
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EntityIIDetail that = (EntityIIDetail) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(description, that.description) &&
        Objects.equals(date, that.date) &&
        options == that.options &&
        Objects.equals(detail, that.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, date, options, detail);
  }
}
