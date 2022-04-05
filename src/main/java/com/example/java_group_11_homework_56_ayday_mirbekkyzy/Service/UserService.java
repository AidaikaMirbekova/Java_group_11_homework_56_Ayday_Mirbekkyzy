package com.example.java_group_11_homework_56_ayday_mirbekkyzy.Service;

import com.example.java_group_11_homework_56_ayday_mirbekkyzy.DTO.UserDTO;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Entity.User;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public void register(UserDTO user) throws Exception {
        var userBuilder = User.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(encoder.encode(user.getPassword()))
                .build();
        userRepository.save(userBuilder);

    }

    @Override
    public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
        return userRepository.getByEmail(useremail).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
