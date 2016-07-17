package com.thoughtworks.api.infrastructure.repositories;

import com.thoughtworks.api.domain.user.User;
import com.thoughtworks.api.domain.user.UserRepository;
import com.thoughtworks.api.support.DatabaseTestRunner;
import com.thoughtworks.api.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(DatabaseTestRunner.class)
public class UserRepositoryTest {
  @Inject
  UserRepository userRepository;

  @Test
  public void should_create_user_with_parameters_and_find_user_by_id() {
    userRepository.create(TestHelper.userMap("1"));

    User user = userRepository.findById("1");

    assertThat(user.getId(), is("1"));
    assertThat(user.getName(), is("firstUser"));
  }
}
