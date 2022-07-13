package com.brandjunhoe.userservice.config

import com.brandjunhoe.userservice.common.code.ErrorCode
import com.brandjunhoe.userservice.common.response.CommonResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.server.ServletServerHttpResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Create by DJH on 2022/06/08.
 */
@Component
class OAuthEntryPoint(val mapper: ObjectMapper) : AuthenticationEntryPoint {

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        /*val res = ServletServerHttpResponse(response)
        res.setStatusCode(HttpStatus.OK)
        res.servletResponse.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        res.body.write(
            mapper.writeValueAsString(
                CommonResponse(
                    ErrorCode.UNAUTHORIZED.status,
                    null,
                    ErrorCode.UNAUTHORIZED.message,
                    null
                )
            ).toByteArray()
        )*/

    }

}