package com.cs.heart_release_01.result;

/**
 * @author Guo Jiaqi
 * @version 1.0
 * @date 2020/9/21 20:31
 */


public class ResultUtil {
    /*
     * 200---成功
     * 301---客户请求的文档在其他的地方
     * 400---请求的语法错误
     * 403---资源不可用
     * 404---找不到网页
     * 500---服务器遇到了意料不到的情况，不能完成客户的请求，一般这个问题是空间商出现了问题，比如空间商被攻击了等等。
     *
     * */

    //成功时候调用
    //因为成功只有一种，所以直接定义码就是200
    public static Result Success(Object object){


        Result<Object> result = new Result();
        result.setCode("200");
        result.setData(object);
        result.setMsg("成功");
        return result;

    }
    //失败的时候调用
    //因为失败的码有好多，所以自定义各种码。
    public static Result Error(String code,String msg,Object object){
        Result<Object> result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;

    }



}
