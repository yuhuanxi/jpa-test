package com.ysp.jpa.repository;

import com.ysp.jpa.domain.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ITeacherRepositoryTest {

  @Autowired
  private ITeacherRepository teacherRepository;

  @Test
  public void save() throws Exception {
    Teacher teacher = new Teacher();
    teacher.setAddress("杭州");
    teacher.setSalary(1000000);
    teacher.setEmail("ddd@qq.com");

    teacherRepository.save(teacher);
  }

  @Test
  public void findByEmail() throws Exception {
    List<Teacher> byEmail = teacherRepository.findByEmail("ddd@qq.com");
  }
}