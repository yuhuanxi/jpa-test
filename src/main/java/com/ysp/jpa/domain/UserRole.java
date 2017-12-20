package com.ysp.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 功能描述.
 *
 * @author shipengfish
 * @version V1.0
 * @date 2017-12-20 16:08
 * @since V1.0
 */
@Entity(name = "user_role")
public class UserRole extends BaseModel {

  private String name;
  @Column(name = "user_id")
  private Long userId;
  private String view;

  @Override
  public String toString() {
    return "UserRole{"
            + "name='" + name + '\''
            + ", userId=" + userId
            + ", view='" + view + '\''
            + "} " + super.toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getView() {
    return view;
  }

  public void setView(String view) {
    this.view = view;
  }
}
