package com.ysp.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * 功能描述.
 *
 * @author shipengfish
 * @version V1.0
 * @date 2017-12-19 18:21
 * @since V1.0
 */
@Entity
@NamedQuery(name = "User.findByAgeLessThan",
        query = "select u from User u where u.age < ?1")
@NamedEntityGraph(name = "User.roles",
        attributeNodes = @NamedAttributeNode("roles"))
public class User extends BaseModel {

  private String username;

  private String password;

  private Integer age;

  private Integer type;

  @OneToMany
  @JoinTable(name = "user_role")
  private List<UserRole> roles;

  public List<UserRole> getRoles() {
    return roles;
  }

  public void setRoles(List<UserRole> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "User{"
            + "username='" + username + '\''
            + ", password='" + password + '\''
            + ", age=" + age
            + ", type=" + type
            + ", roles=" + roles
            + "} " + super.toString();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }
}
