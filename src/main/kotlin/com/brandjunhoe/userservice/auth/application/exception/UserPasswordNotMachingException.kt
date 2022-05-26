package com.brandjunhoe.userservice.auth.application.exception

import com.brandjunhoe.userservice.common.code.ErrorCode
import com.brandjunhoe.userservice.common.exception.BadRequestException

/**
 * Create by DJH on 2022/05/26.
 */
class UserPasswordNotMachingException : BadRequestException(ErrorCode.USER_PASSWORD_NOT_MACHING)