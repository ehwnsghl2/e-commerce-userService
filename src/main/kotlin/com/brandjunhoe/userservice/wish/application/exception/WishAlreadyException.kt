package com.brandjunhoe.userservice.wish.application.exception

import com.brandjunhoe.userservice.common.code.ErrorCode
import com.brandjunhoe.userservice.common.exception.BadRequestException

/**
 * Create by DJH on 2022/05/26.
 */
class WishAlreadyException : BadRequestException(ErrorCode.WISH_ALREADY)