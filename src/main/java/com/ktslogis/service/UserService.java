package com.ktslogis.service;

import com.ktslogis.dto.UserDto;
import com.ktslogis.entity.User;
import com.ktslogis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional(readOnly = false)
    public int save(UserDto dto) throws Exception {

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEnabled(dto.isEnabled());

        //todo - change the below two fields based on future requirements
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);

        User result = repository.save(user);

        System.out.println(result);

        return result.getId();
    }

    public int update(UserDto dto) {
        Optional<User> optional = repository.findById(dto.getId());
        User user = optional.get();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEnabled(dto.isEnabled());

        //todo - change the below two fields based on future requirements
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);

        User result = repository.save(user);

        System.out.println(result);

        return result.getId();
    }

    public List<UserDto> getAll() {
        List<User> allUsers = repository.findAll();

        List<UserDto> allUserDtos = new ArrayList<>();


        for (User user : allUsers) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setUsername(user.getUsername());
            userDto.setEnabled(user.isEnabled());

            allUserDtos.add(userDto);
        }

        return allUserDtos;
    }

}
