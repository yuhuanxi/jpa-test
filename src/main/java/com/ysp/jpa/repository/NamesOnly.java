package com.ysp.jpa.repository;

/**
 * 功能描述.
 *
 * @author shipengfish
 * @version V1.0
 * @date 2017-12-20 17:49
 * @since V1.0
 */
public interface NamesOnly {

  String getUsername();

  int getAge();

  /**
   * 可联合使用
   */
//  @Value("#{target.username + ' ' + target.age + ' ' + target.password}")
//  String getUserInfo();
}
