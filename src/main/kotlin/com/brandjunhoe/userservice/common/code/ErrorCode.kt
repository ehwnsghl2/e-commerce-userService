package com.brandjunhoe.userservice.common.code

import org.springframework.http.HttpStatus


enum class ErrorCode(val status: Int, val code: Int?, val message: String) {


    // 4XX
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400,"잘못된 요청입니다."),

    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), 401,"Unauthorized"),
    FORBIDDEN(HttpStatus.FORBIDDEN.value(), 403,"Forbidden"),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND.value(), 404,"Not found"),

    USER_EMAIL_ALREADY_USE(HttpStatus.BAD_REQUEST.value(), 101,"user email was already use"),
    USER_PASSWORD_NOT_MACHING(HttpStatus.BAD_REQUEST.value(), 102,"user password not maching"),
    USER_MILEAGE_ALREADY(HttpStatus.BAD_REQUEST.value(), 104,"mileage was already saved"),

    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED.value(), 405,"해당 메서드는 해당되지 않습니다."),
    UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), 415,"지원하지 않는 HTTP 메서드입니다"),
    CONFLICT(HttpStatus.CONFLICT.value(), 409,"이미 사용 중인 데이터 입니다."),

    //5XX
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500,"서버에러가 발생했습니다. 서버 관리자에게 문의하세요")


}