package com.brandjunhoe.userservice.user.application.exception

import com.brandjunhoe.userservice.common.code.ErrorCode
import com.brandjunhoe.userservice.common.exception.BadRequestException

/**
 * Create by DJH on 2022/05/25.
 */
class UserEmailAlreadyException : BadRequestException(ErrorCode.USER_EMAIL_ALREADY_USE)