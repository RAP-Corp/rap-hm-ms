package com.rap.microservices.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration {

  /*  @Bean
    UserDetailsRepository userDetailsRepository() {
        UserDetails brijesh = withUsername("brijesh").password("password").roles("USER").build();
        UserDetails singh = withUsername("singh").password("password").roles("USER", "ADMIN").build();
        return new MapUserDetailsRepository (brijesh, singh);
    }*/


   /* @Autowired
    UserDetailsService userDetailsService ;

    @Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService);
    }*/

}
