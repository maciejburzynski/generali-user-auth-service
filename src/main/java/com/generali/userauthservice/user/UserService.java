package com.generali.userauthservice.user;

import java.util.Optional;

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
  UserMapper userMapper = UserMapper.INSTANCE;

  UserLoginResponse validateUser(UserDto userDto) {
    try {
      return jwtService.validateUserAndGenerateToken(userDto);
    } catch (RuntimeException exception) {
      return new UserLoginResponse(null, exception.getMessage());
    }
  }

  public Page<User> findAll(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  public Optional<User> findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public void updateUserByUsername(User user) {
    userRepository.save(user);
  }

  public User findByPassword(String password) {
    return userRepository.findUserByPassword(password).orElseThrow(() -> new RuntimeException("User with this password does not exist"));
  }

  public void registerUser(UserDto userDto) {
    User user = userMapper.mapDtoToEntity(userDto);
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    userRepository.save(user);
  }
}
