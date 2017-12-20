package com.ysp.jpa.repository;

import com.ysp.jpa.domain.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * 功能描述.
 *
 * @author shipengfish
 * @version V1.0
 * @date 2017-12-20 14:35
 * @since V1.0
 */
@NoRepositoryBean
public interface IBaseRepository<T extends BaseModel> extends JpaRepository<T, Long> {

  @Query("select t from #{#entityName} t where t.email = ?1")
  List<T> findByEmail(String email);
}
