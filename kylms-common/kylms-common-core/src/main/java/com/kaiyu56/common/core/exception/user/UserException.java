package com.kaiyu56.common.core.exception.user;

import com.kaiyu56.common.core.exception.BaseException;

/**
 * 用户信息异常类
 * 
 * @author css
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
