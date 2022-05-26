package com.brandjunhoe.userservice.common.exception

import com.brandjunhoe.userservice.common.code.ErrorCode


open class BadRequestException(val errorCode: ErrorCode) : RuntimeException()