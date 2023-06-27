package ru.otus.library.service.user;

import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.otus.library.entity.User;
import ru.otus.library.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    log.info("loadUserByUsername: {}", username);

    return userRepository.findByUsername(username)
        .map(user -> {
          List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
          return buildUserForAuthentication(user, authorities);
        })
        .orElseThrow(() -> new UsernameNotFoundException("username " + username + " not found!"));
  }

  private List<GrantedAuthority> buildUserAuthority(String role) {
    return Collections.singletonList(new SimpleGrantedAuthority(role));
  }

  private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
  }
}
