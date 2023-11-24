package com.generali.userauthservice.user;

import java.util.List;
import java.util.Optional;

import com.generali.userauthservice.jwt.JwtService;
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

  public List<User> findAll() {
    UserSpecification userSpecification = new UserSpecification();
    userSpecification.add(new SearchCriteria("username", "user", SearchOperation.EQUAL));
    return userRepository.findAll(userSpecification);



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
