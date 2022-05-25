package com.brandjunhoe.userservice.common.handler

import com.brandjunhoe.userservice.cart.application.exception.CartNotFoundException
import com.brandjunhoe.userservice.cart.application.exception.CartProductNotMatchingException
import com.brandjunhoe.userservice.common.code.ErrorException
import com.brandjunhoe.userservice.common.code.ErrorCode
import com.brandjunhoe.userservice.common.exception.BadRequestException
import com.brandjunhoe.userservice.common.exception.DataNotFoundException
import com.brandjunhoe.userservice.common.response.CommonResponse
import com.brandjunhoe.userservice.mileage.application.exception.UserMileageNotFoundException
import com.brandjunhoe.userservice.user.application.exception.UserNotFoundException
import com.brandjunhoe.userservice.wish.application.exception.WishNotFoundException
import com.brandjunhoe.userservice.wish.application.exception.WishProductNotMatchingException
import org.apache.http.auth.AuthenticationException
import org.springframework.beans.BeanInstantiationException
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.multipart.MaxUploadSizeExceededException
import java.io.IOException
import java.util.*
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class GlobalExceptionHandler {

    @ExceptionHandler(
        value = [
            HttpMessageNotReadableException::class,
            HttpRequestMethodNotSupportedException::class,
            MaxUploadSizeExceededException::class,
            BindException::class,
            MethodArgumentNotValidException::class,
            IllegalArgumentException::class,
            BeanInstantiationException::class,
            AuthenticationException::class,
            AccessDeniedException::class,
            javax.websocket.DecodeException::class,
            MethodArgumentTypeMismatchException::class,
            IOException::class,
            BadRequestException::class,
            DataNotFoundException::class,
            UserNotFoundException::class,
            CartNotFoundException::class,
            WishNotFoundException::class,
            UserMileageNotFoundException::class,
            CartProductNotMatchingException::class,
            WishProductNotMatchingException::class,
            Exception::class
        ]
    )
    @Throws(Exception::class)
    fun commonExcetpion(e: Exception, request: HttpServletRequest, webRequest: WebRequest): CommonResponse<Unit> {

        val errorCode = when (e::class.java.simpleName) {
            // 데이터 찾지 못하는 경우
            ErrorException.DataNotFoundException.name,
            ErrorException.UserNotFoundException.name,
            ErrorException.CartNotFoundException.name,
            ErrorException.UserMileageNotFoundException.name
            -> ErrorCode.DATA_NOT_FOUND
            // validate 에러
            ErrorException.BindException.name,
            ErrorException.MethodArgumentNotValidException.name,
            ErrorException.HttpMessageNotReadableException.name,
            ErrorException.HttpRequestMethodNotSupportedException.name,
            ErrorException.IllegalArgumentException.name,
            ErrorException.FormValidationException.name,
                // 잘못된 요청
            ErrorException.BadRequestException.name -> ErrorCode.BAD_REQUEST
            // 인증 실패
            ErrorException.AuthenticationException.name -> ErrorCode.UNAUTHORIZED
            // 권한 거부
            ErrorException.AccessDeniedException.name -> ErrorCode.FORBIDDEN
            // Feignt 매칭 실패
            ErrorException.WishProductNotMatchingException.name,
            ErrorException.CartProductNotMatchingException.name
            -> ErrorCode.INTERNAL_SERVER_ERROR
            // 서버 에러
            else -> ErrorCode.INTERNAL_SERVER_ERROR
        }

        return CommonResponse(errorCode.status, errorCode.code, errorCode.message)

    }


}