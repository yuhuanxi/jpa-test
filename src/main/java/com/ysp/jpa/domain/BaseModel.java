package com.ysp.jpa.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 功能描述.
 *
 * @author shipengfish
 * @version V1.0
 * @date 2017-12-20 14:33
 * @since V1.0
 */
@MappedSuperclass
public class BaseModel {

  @Id
  @GeneratedValue
  private Long id;

  private String email;

  @Override
  public String toString() {
    return "BaseModel{"
            + "id=" + id
            + ", email='" + email + '\''
            + '}';
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
