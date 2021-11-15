package com.nateshao.swagger.model;

import com.nateshao.swagger.utils.HttpStatus;
import com.nateshao.swagger.utils.StringUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * @date Created by 邵桐杰 on 2021/11/14 22:44
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Data
public class AjaxResult<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private T data;

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult()
    {
    }
    public static AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.message("操作失败,修改行数0");
    }
    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     */
    public AjaxResult(int code, String msg)
    {
        this.code = code;
        this.msg = msg;

    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public AjaxResult(int code, String msg, T data)
    {
        this.code = code;
        this.msg = msg;
        if (StringUtils.isNotNull(data))
        {
            this.data = data;
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static<T> AjaxResult<T> success()
    {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static<T> AjaxResult<T> success(T data)
    {
        return AjaxResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static<T> AjaxResult<T> success(String msg)
    {
        return AjaxResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static<T> AjaxResult<T> success(String msg, T data)
    {
        return new AjaxResult(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static<T> AjaxResult<T> error()
    {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static<T> AjaxResult<T> error(String msg)
    {
        return AjaxResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static<T> AjaxResult<T> error(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg 返回内容
     * @return 警告消息
     */
    public static<T> AjaxResult<T> error(int code, String msg)
    {
        return new AjaxResult(code, msg, null);
    }

    /**
     * 返回消息，程序为正常进行，可能是校验不通过
     * @param msg
     * @param <T>
     * @return
     */
    public static<T> AjaxResult<T> message(String msg) {
        return new AjaxResult<>(HttpStatus.UNAUTHORIZED, msg);
    }
}
