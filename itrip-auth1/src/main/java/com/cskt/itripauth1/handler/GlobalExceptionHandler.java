package com.cskt.itripauth1.handler;

import com.aliyun.oss.ServiceException;
import com.cskt.itripauth1.exception.DaoException;
import com.cskt.itripauth1.exception.SysException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cskt.common.constants.ErrorCodeEnum;
import com.cskt.common.vo.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一异常处理器
 * @author 22-贺杜娟
 * @create 2021-01-0511:13
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /*** 捕获异常 * @param e 异常类型为 Exception * @return */
    @ExceptionHandler(value = Exception.class)
    public ReturnResult error(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return ReturnResult.error(ErrorCodeEnum.SYSTEM_EXECUTION_ERROR);
    }

    /*** 捕获异常 * @param e 异常类型为 ServiceException * @return */
    @ExceptionHandler(value = ServiceException.class)
    public ReturnResult error(ServiceException e) {
        LOGGER.error(e.getMessage(), e);
        return ReturnResult.error(e.getErrorCode(),e.getMessage());
    }

    /*** 捕获异常 * @param e 异常类型为 DaoException * @return */
    @ExceptionHandler(value = DaoException.class)
    public ReturnResult error(DaoException e) {
        LOGGER.error(e.getMessage(), e);
        return ReturnResult.error(e.getErrorCode(),e.getMessage());
    }

    @ExceptionHandler(value = SysException.class)
    public ReturnResult error(SysException e) {
        LOGGER.error(e.getMessage(), e); return ReturnResult.error(e.getErrorCode(), e.getMessage());
    }
}
