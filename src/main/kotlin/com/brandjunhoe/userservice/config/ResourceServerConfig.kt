package com.brandjunhoe.userservice.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.web.AuthenticationEntryPoint

/**
 * Create by DJH on 2022/06/08.
 */
@EnableResourceServer
@Configuration
class ResourceServerConfig(val oauthEntryPoint: AuthenticationEntryPoint) : ResourceServerConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        http.headers()
            .frameOptions()
            .disable()


        http.authorizeRequests()
            // swagger 주소 허용
            /*.antMatchers(
                "/api/v1/user/signin"
            ).permitAll()*/
            .antMatchers("/**").access("#oauth2.hasScope('user')")
            //.antMatchers("/**").permitAll()
            .anyRequest()
            .authenticated()


    }


    @Throws(Exception::class)
    override fun configure(resources: ResourceServerSecurityConfigurer) {
        super.configure(resources)
        resources.authenticationEntryPoint(oauthEntryPoint)
    }

}