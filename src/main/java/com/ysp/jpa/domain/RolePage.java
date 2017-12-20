package com.ysp.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 功能描述.
 *
 * @author shipengfish
 * @version V1.0
 * @date 2017-12-20 16:53
 * @since V1.0
 */
@Entity(name = "role_page")
public class RolePage extends BaseModel {

  private String name;
  @Column(name = "role_id")
  private Long roleId;
  @Column(name = "has_more")
  private String hasMore;

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return "RolePage{"
            + "name='" + name + '\''
            + ", roleId=" + roleId
            + ", hasMore='" + hasMore + '\''
            + "} " + super.toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHasMore() {
    return hasMore;
  }

  public void setHasMore(String hasMore) {
    this.hasMore = hasMore;
  }
}
