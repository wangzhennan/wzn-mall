package com.wzn.mall.exception;

import com.wzn.mall.ResultModel;
import com.wzn.mall.error.SysErrorCode;
import com.wzn.mall.log.LogUtil;
import com.wzn.mall.log.MallLogger;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @program: wzn-mall
 * @description: 异常处理
 * @author: wangzhennan
 * @create: 2020-04-13 16:42
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String SERVER_ERROR_MESSAGE = "服务异常，请稍后再试";

    /**
     * 全局异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultModel errorHandler(HttpServletRequest request, Exception ex) {
        MallLogger.error(LogUtil.getLogId(), ex.getMessage(), ex);
        ex.printStackTrace();
        return ResultModel.error(SysErrorCode.SYS_ERROR);
    }

    /**
     * 校验异常
     */
    @ExceptionHandler(value = BindException.class)
    public ResultModel validationExceptionHandler(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String errorMesssage = "";
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage += fieldError.getDefaultMessage() + "!";
        }
        return ResultModel.error(SysErrorCode.VIOLATION_ERROR.getCode(), errorMesssage);
    }

    /**
     * 校验异常
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResultModel ConstraintViolationExceptionHandler(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        List<String> msgList = new ArrayList<>();
        while (iterator.hasNext()) {
            ConstraintViolation<?> cvl = iterator.next();
            msgList.add(cvl.getMessageTemplate());
        }
        return ResultModel.error(SysErrorCode.VIOLATION_ERROR.getCode(), String.join(",", msgList));
    }

    /**
     * 针对MethodArgumentNotValidException错误
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultModel methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        String message = "";
        if (!CollectionUtils.isEmpty(allErrors)) {
            message = allErrors.get(0).getDefaultMessage();
        }
        return ResultModel.error(SysErrorCode.VIOLATION_ERROR.getCode(), String.format(SysErrorCode.VIOLATION_ERROR.getMessage(), message));
    }

}
