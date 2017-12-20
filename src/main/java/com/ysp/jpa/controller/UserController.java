package com.ysp.jpa.controller;

import com.ysp.jpa.domain.User;
import com.ysp.jpa.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 功能描述.
 *
 * @author shipengfish
 * @version V1.0
 * @date 2017-12-20 10:29
 * @since V1.0
 */
@RestController
public class UserController {

  @Autowired
  private IUserRepository userRepository;

  @PostMapping("/user")
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @GetMapping("/user")
  public String findUser(String username) throws ExecutionException, InterruptedException {

    CompletableFuture<User> oneByUsername = userRepository.findOneByUsername(username);

    oneByUsername.thenRunAsync(() -> {
      try {
        printName(oneByUsername.get(), a -> System.out.println(a.getUsername()));
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    });

    System.out.println("-------------");

    oneByUsername.thenAcceptAsync(a -> {
      try {
        Thread.sleep(TimeUnit.SECONDS.toMillis(10));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("--- accept async begin");
      System.out.println(a.getUsername());
      System.out.println("--- accept async end");
    });

    return oneByUsername.get().getUsername();
  }

  @GetMapping("/users")
  public List<User> readAll(Integer curPage, Integer pageSize) {
    Pageable pageable = new PageRequest(curPage, pageSize);
    return userRepository.streamAll(pageable);
  }

  @GetMapping("/users/{username}")
  public List<User> sliceUser(String username, Integer curPage, Integer pageSize) {
    Pageable pageable = new PageRequest(curPage, pageSize);
    Slice<User> byUsername = userRepository.findByUsername(username, pageable);
    System.out.println(byUsername.hasNext());
    return byUsername.getContent();
  }

  @GetMapping("/users/sort")
  public List<User> findByAndSort(String username, Integer curPage, Integer pageSize) {
    Sort sort = new Sort(Sort.Direction.DESC, "age");
    Pageable pageable = new PageRequest(curPage, pageSize);
    return userRepository.findByAndSort(username, sort);
  }

  private void printName(User u, Consumer<User> c) throws InterruptedException {
    System.out.println("---begin print name---");
    Thread.sleep(TimeUnit.MINUTES.toMillis(1));
    c.accept(u);
    System.out.println("---print name successfully---");
  }
}

