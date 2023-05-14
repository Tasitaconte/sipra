package com.sipra.fesc.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // @Autowired
    // IUserRepository iUsuarioRepository;

    // @Autowired
    // IRolRepositories iRolRepositories;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // UserEntidad usuarioEntity = iUsuarioRepository.findOneByEmail(email);

        // if (usuarioEntity == null) {
        //     throw new UsernameNotFoundException(email);
        // }

        // return new UserDetailsImpl(usuarioEntity);
        return new UserDetailsImpl();
    }

}