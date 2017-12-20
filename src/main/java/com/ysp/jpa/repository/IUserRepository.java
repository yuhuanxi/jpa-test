package com.ysp.jpa.repository;

import com.ysp.jpa.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 功能描述.
 *
 * @author shipengfish
 * @version V1.0
 * @date 2017-12-20 10:24
 * @since V1.0
 */
@Repository
public interface IUserRepository extends IBaseRepository<User> {

  long countByUsername(String username);

  @Override
  User save(User user);

  @Async
  CompletableFuture<User> findOneByUsername(String username);

  @Query("select u from User u")
  List<User> streamAll(Pageable pageable);

  /**
   * 分页
   *
   * @param username
   * @param pageable
   * @return
   */
  Slice<User> findByUsername(String username, Pageable pageable);

  /**
   * 使用 sort
   *
   * @param username
   * @param sort
   * @return
   */
  @Query("select u from User u where u.username like ?1%")
  List<User> findByAndSort(String username, Sort sort);

  @Query("select u.id, LENGTH(u.username) as fn_len from User u where u.username like ?1%")
  List<Object[]> findByAsArrayAndSort(String username, Sort sort);

  /**
   * 使用 NameQuery
   *
   * @param age
   * @return
   */
  List<User> findByAgeLessThan(int age);

  /**
   * 指定别名
   *
   * @param username
   * @return
   */
  @Query("select u from User u where u.username = :name")
  List<User> findByLastnameOrFirstname(@Param("name") String username);

  /**
   * 此方法返回 Object[] 集合
   *
   * @param username
   * @return
   */
  @Query("select u from User u where u.username = ?1")
  List<User> findByUsername(String username);

  /**
   * 更新
   *
   * @param id
   * @return
   */
  @Modifying
  @Transactional
  @Query(value = "update User u set u.age = u.age - 1 where u.id = ?1")
  int setAgeFor(Long id);

  /**
   * 删除
   *
   * @param id
   */
  @Modifying
  @Transactional
  @Query("delete from User u where u.id = ?1")
  void deleteById(Long id);

  @EntityGraph(value = "User.roles", type = EntityGraph.EntityGraphType.LOAD)
  User findById(Long id);

}
