package com.ysp.jpa.repository;


import com.ysp.jpa.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserRepositoryTest {

  @Autowired
  private IUserRepository userRepository;

  @Test
  public void findByAgeLessThan() throws Exception {
    List<User> byAgeLessThan = userRepository.findByAgeLessThan(30);

  }

  @Test
  public void findByLastnameOrFirstname() throws Exception {
    List<User> yhx = userRepository.findByLastnameOrFirstname("yhx");
  }

  @Test
  public void findByEmail() throws Exception {
    List<User> yhx = userRepository.findByEmail("aaa@qq.com");
  }

  @Test
  public void decreaseAge() throws Exception {
    int i = userRepository.setAgeFor(7L);
  }

  @Test
  public void deleteById() throws Exception {
    userRepository.deleteById(7L);
  }

  @Test
  public void findByUsername() throws Exception {
    List<User> yhx = userRepository.findByUsername("yhx");
//    System.out.println(yhx.get(0).getRoles());
    System.out.println(yhx);
  }

  @Test
  public void findById() throws Exception {
    User yhx = userRepository.findById(3L);
//    System.out.println(yhx.get(0).getRoles());
    System.out.println(yhx);

//    System.out.println(yhx.getRoles());

//    System.out.println(yhx.getRoles().get(0).getPages());
  }

}