package com.sipra.fesc.Security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.example.demo.services.IUserService;
// import com.example.demo.shared.UserDto;
// import com.example.demo.utils.AppContexto;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        UsuarioSignupRequestModel usuarioSignupRequestModel = new UsuarioSignupRequestModel();

        try {
            usuarioSignupRequestModel = new ObjectMapper().readValue(request.getInputStream(),
                    UsuarioSignupRequestModel.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                usuarioSignupRequestModel.getEmail(),
                usuarioSignupRequestModel.getPassword(),
                Collections.emptyList());

        return getAuthenticationManager().authenticate(upat);

    }

    @Autowired
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        UserDetailsImpl userDatails = (UserDetailsImpl) authResult.getPrincipal();

        // String token = TokenUtils.createToken(userDatails.getNombre(), userDatails.getUsername());

        // IUserService iuserService = (IUserService) AppContexto.getBean("userService");
        // UserDto userDto = iuserService.leerUser(userDatails.getUsername());
        System.out.println(userDatails.getAuthorities());

        response.addHeader("Access-Control-Expose-Headers", "Authorization, idUsuario, idRol, nombre, apellido,role");
/*         response.addHeader("idUsuario", userDatails.getIdUser().toString());
        response.addHeader("idRol", userDatails.getIdRol().toString());
        response.addHeader("nombre", userDatails.getNombre());
        response.addHeader("apellido", userDatails.getApellido());
        response.addHeader("role", userDatails.getAuthorities().toString()); */

        // response.addHeader(ConstantesSecurity.HEADER_STRING, ConstantesSecurity.TOKEN_PREFIJO + token);
        // response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);

    }

}