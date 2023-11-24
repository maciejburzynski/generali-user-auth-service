package com.generali.userauthservice.user;

import java.util.List;
import java.util.Optional;

import com.generali.userauthservice.jwt.JwtService;
import com.generali.userauthservice.user.jpaspecification.SearchCriteria;
import com.generali.userauthservice.user.jpaspecification.SearchOperation;
import com.generali.userauthservice.user.jpaspecification.UserRepository;
import com.generali.userauthservice.user.jpaspecification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final UserActivationClient userActivationClient;
  UserMapper userMapper = UserMapper.INSTANCE;

  UserLoginResponse validateUser(UserDto userDto) {
    try {
      return jwtService.validateUserAndGenerateToken(userDto);
    } catch (RuntimeException exception) {
      return new UserLoginResponse(null, exception.getMessage());
    }
  }

  public Page<User> findAll(Pageable pageable) {

    UserSpecification userSpecification = new UserSpecification();
    userSpecification.add(new SearchCriteria("username", List.of("user", "superadmin"), SearchOperation.IN));

    return userRepository.findAll(userSpecification, pageable);

  }

  public Optional<User> findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public void registerUser(UserDto userDto) {
    User user = userMapper.mapDtoToEntity(userDto);
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    userRepository.save(user);
    userActivationClient.activateUser(user);
  }

  public User activateUser(String uuid) {
    User userToActivate = userRepository.findUserByUuid(uuid).orElseThrow(() -> new UserNotFoundException("User with uuid: " + uuid + "not found"));
    userToActivate.setEnabled(true);
    userToActivate.setAccountNonExpired(true);
    userToActivate.setAccountNonLocked(true);
    userToActivate.setCredentialsNonExpired(true);
    userRepository.save(userToActivate);
    return userToActivate;
  }
}
