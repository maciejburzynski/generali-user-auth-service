package com.generali.userauthservice.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  User mapDtoToEntity(UserDto userDto);
  UserDto mapEntityToDto(User user);

}
