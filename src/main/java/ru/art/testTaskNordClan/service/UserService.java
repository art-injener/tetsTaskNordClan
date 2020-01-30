package ru.art.testTaskNordClan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.art.testTaskNordClan.repository.UserRepository;

/**
 * Class provides core user information.
 * @author Danilchenko Artem
 */
@Service
public class UserService implements UserDetailsService {
    /** provides of  user repository*/
    @Autowired
    private UserRepository userRepository;

    /**
     * Locates the user based on the username.
     * @param s -  the username identifying the user whose data is required.
     * @return a fully populated user record (never null)
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }
}
