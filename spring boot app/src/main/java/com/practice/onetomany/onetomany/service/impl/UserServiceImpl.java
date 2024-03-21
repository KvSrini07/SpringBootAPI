package com.practice.onetomany.onetomany.service.impl;

import com.practice.onetomany.onetomany.entity.User;
import com.practice.onetomany.onetomany.repository.UserRepository;
import com.practice.onetomany.onetomany.service.UserService;
import com.practice.onetomany.onetomany.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UsersService {

    private final UserRepository usersRepository;

    public UserServiceImpl(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return usersRepository.findById(userId);
    }

    @Override
    public User saveUser(User user) {
        return usersRepository.save(user);
    }

    @Override
    public User updateUsers(User user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        usersRepository.deleteById(userId);
    }
}
//    private UsersRepository usersRepository;
//    @Override
//    public UserDto createUser(UserDto userDto) {
//        UsersModel usersModel = UserMapper.mapToUser(userDto);
//        UsersModel saveduser =usersRepository.save(usersModel);
//        return UserMapper.mapToUserDto(saveduser);
//    }
//
//    @Override
//    public UserDto getUserById(Long userId) {
//        UsersModel usersModel = usersRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User is not exists with given id"));
//        return UserMapper.mapToUserDto(usersModel);
//    }
//
//    @Override
//    public List<UserDto> getAllUser() {
//        List<UsersModel> usersModels = usersRepository.findAll();
//        return usersModels.stream().map((usersModel) -> UserMapper.mapToUserDto(usersModel))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public UserDto updateUser(Long userId, UserDto updateUser) {
//        UsersModel usersModel = usersRepository.findById(userId).orElseThrow(
//                ()-> new ResourceNotFoundException("User is not exists with given id:" +userId)
//        );
//        usersModel.setStud_name(updateUser.getStud_name());
//        usersModel.setEmail(updateUser.getEmail());
//
//        UsersModel updateUserObj = usersRepository.save(usersModel);
//
//        return UserMapper.mapToUserDto(updateUserObj);
//    }
//
//    @Override
//    public void deleteUser(Long userId) {
//
//        UsersModel usersModel = usersRepository.findById(userId).orElseThrow(
//                ()-> new ResourceNotFoundException("User is not exists with given id:" +userId)
//        );
//
//        usersRepository.deleteById(userId);
//    }
//}
