package com.ysp.jpa.domain;

import javax.persistence.Entity;

/**
 * 功能描述.
 *
 * @author shipengfish
 * @version V1.0
 * @date 2017-12-20 14:51
 * @since V1.0
 */
@Entity
public class Teacher extends BaseModel {

  private String address;

  private Integer salary;

  @Override
  public String toString() {
    return "Teacher{"
            + "address='" + address + '\''
            + ", salary=" + salary
            + "} " + super.toString();
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }
}
