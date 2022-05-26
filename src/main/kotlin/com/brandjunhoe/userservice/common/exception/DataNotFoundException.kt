package com.brandjunhoe.userservice.common.exception

import com.brandjunhoe.userservice.common.code.ErrorCode

open class DataNotFoundException : RuntimeException() {
    val errorCode: ErrorCode = ErrorCode.DATA_NOT_FOUND
}