package com.mkyong.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

  @Id
  @Column
  private long id;
  @Column
  private String name;
  @Column
  private String secondname;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSecondname() {
    return secondname;
  }

  public void setSecondname(String secondname) {
    this.secondname = secondname;
  }

}
