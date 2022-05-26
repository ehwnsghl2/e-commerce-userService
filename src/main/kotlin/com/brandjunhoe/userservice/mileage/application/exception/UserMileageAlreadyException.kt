package com.brandjunhoe.userservice.mileage.application.exception

import com.brandjunhoe.userservice.common.code.ErrorCode
import com.brandjunhoe.userservice.common.exception.BadRequestException

/**
 * Create by DJH on 2022/05/26.
 */
class UserMileageAlreadyException : BadRequestException(ErrorCode.USER_MILEAGE_ALREADY)