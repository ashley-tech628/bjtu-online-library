/**
 */
package com.framework.web.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/***
 * Date:2021/6/26
 * Title: Rest返回
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
@Data
@Accessors(chain = true)
public class CommonResult<T> {

    /**
     * 调用是否成功标识，0：成功，详情见[ResCode]
     */
    private int code;

    /**
     * 调用结果
     */
    private T result;

    /**
     * 结果消息，如果调用成功，消息通常为空T
     */
    private String message = "";


    public CommonResult() {

    }

    public CommonResult(int code, T result, String msg) {
        this.code = code;
        this.result = result;
        this.message = msg;
    }


    ////////////////////////////////////////////////////


    /**
     * Function:请求返回消息
     * Author: Admin
     * Date:2021/6/26
     * @param code
     * @param result
     * @param msg
     * @return com.bjtuwh.web.domain.Result<E>
     * @throws Exception
     */
    public static <E> CommonResult<E> result(int code, E result, String msg) {
        return new CommonResult<>(code, result, msg);
    }


    /**
     * Function:请求成功方法 ，data返回值，msg提示信息
     * Author: Admin
     * Date:2021/6/26
     * @param
     * @return com.bjtuwh.web.domain.Result<E>
     * @throws Exception
     */
    public static <E> CommonResult<E> success() {
        return result(ResultCode.SUCCESS.getCode(), null, ResultCode.SUCCESS.getMsg());
    }

    /**
     * Function:请求成功方法 ，data返回值，msg提示信息
     * Author: Admin
     * Date:2021/6/26
     * @param
     * @return com.bjtuwh.web.domain.Result<E>
     * @throws Exception
     */
    public static <E> CommonResult<E> success(String msg) {
        return result(ResultCode.SUCCESS.getCode(), null, msg);
    }


    /**
     * Function:求成功消息，data返回值
     * Author: Admin
     * Date:2021/6/26
     * @param result
     * @return com.bjtuwh.web.domain.Result<E>
     * @throws Exception
     */
    public static <E> CommonResult<E> success(E result) {
        return result(ResultCode.SUCCESS.getCode(), result, ResultCode.SUCCESS.getMsg());
    }

    /**
     * Function:请求成功方法 ，data返回值，msg提示信息
     * Author: Admin
     * Date:2021/6/26
     * @param result
     * @param msg
     * @return com.bjtuwh.web.domain.Result
     * @throws Exception
     */
    public static <E> CommonResult<E> success(E result, String msg) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), result, msg);
    }


    /**
     * Function:请求失败消息,操作失败
     * Author: Admin
     * Date:2021/6/26
     * @return com.bjtuwh.web.domain.Result
     * @throws Exception
     */
    public static <E> CommonResult<E> failure() {
        return result(ResultCode.FAILURE.getCode(), null, null);
    }

    /**
     * Function:请求失败消息,操作失败
     * Author: Admin
     * Date:2021/6/26
     * @param resCode
     * @return com.bjtuwh.web.domain.Result
     * @throws Exception
     */
    public static <E> CommonResult<E> failure(ResultCode resCode) {
        return result(resCode.getCode(), null, resCode.getMsg());
    }

    /**
     * Function:请求失败消息,操作失败
     * Author: Admin
     * Date:2021/6/26
     * @param msg
     * @return com.bjtuwh.web.domain.Result
     * @throws Exception
     */
    public static <E> CommonResult<E> failure(String msg) {
        return result(ResultCode.FAILURE.getCode(), null, msg);
    }

    /**
     * Function:请求失败消息,操作失败
     * Author: Admin
     * Date:2021/6/26
     * @param msg
     * @return com.bjtuwh.web.domain.Result
     * @throws Exception
     */
    public static <E> CommonResult<E> failure(E result, String msg) {
        return new CommonResult<>(ResultCode.FAILURE.getCode(), result, msg);
    }

    /**
     * Function:请求失败消息,操作失败
     * Author: Admin
     * Date:2021/6/26
     * @param code
     * @param msg
     * @return com.bjtuwh.web.domain.Result
     * @throws Exception
     */
    public static <E> CommonResult<E> failure(int code, String msg) {
        return result(code, null, (msg == null || msg.isEmpty()) ? ResultCode.getExceptionCodeByDefaultError(code).getMsg() : msg);
    }

    /**
     * Function:请求失败消息,操作失败
     * Author: Admin
     * Date:2021/6/26
     * @param code
     * @param msg
     * @return com.bjtuwh.web.domain.Result
     * @throws Exception
     */
    public static <E> CommonResult<E> failure(int code, E result, String msg) {
        return result(code, result, (msg == null || msg.isEmpty()) ? ResultCode.getExceptionCodeByDefaultError(code).getMsg() : msg);
    }


    /**
     * Function:返回操作,携带默认返回值
     * Author: Admin
     * Date:2021/6/27
     * @param b true：成功，false：失败
     * @return com.bjtuwh.web.domain.Result<T>
     * @throws Exception
     */
    public static <T> CommonResult<T> auto(boolean b) {
        return auto(b, ResultCode.SUCCESS.getMsg(), ResultCode.FAILURE.getMsg());
    }

    /**
     * Function:返回操作,携带自定义消息
     * Author: Admin
     * Date:2021/6/27
     * @param b       true：成功，false：失败
     * @param success 成功提示
     * @param failure 失败提示
     * @return com.bjtuwh.web.domain.Result<T>
     * @throws Exception
     */
    public static <T> CommonResult<T> auto(boolean b, String success, String failure) {
        if (b) {
            return success(success);
        } else {
            return failure(failure);
        }
    }

    /**
     * Function:返回值obj如果为null那么响应fail，否则响应success
     * Author: Admin
     * Date:2021/6/27
     * @param obj 返回对象
     * @return com.bjtuwh.web.domain.Result<T>
     * @throws Exception
     */
    public static <T> CommonResult<T> auto(T obj) {
        return auto(obj, ResultCode.SUCCESS.getMsg(), ResultCode.FAILURE.getMsg());
    }

    /**
     * Function:返回值obj如果为null那么响应fail，否则响应success
     * Author: Admin
     * Date:2021/6/27
     * @param obj     返回对象
     * @param success 成功提示
     * @param failure 失败提示
     * @return com.bjtuwh.web.domain.Result<T>
     * @throws Exception
     */
    public static <T> CommonResult<T> auto(T obj, String success, String failure) {
        if (null == obj) {
            return failure(failure);
        } else {
            return success(obj, success);
        }
    }


    /**
     * Excel导入返回信息
     * @param successNum 成功条数
     * @param failNum 失败条数
     * @param successMsg 成功消息
     * @param failureMsg 失败消息
     * @return 响应信息
     */
    public static CommonResult result(int successNum, int failNum, StringBuilder successMsg, StringBuilder failureMsg) {
        Map<String, String> result = new HashMap<>();

        // 返回信息
        if (failNum > 0) {
            String msg = String.format("共 %s 条数据导入成功,共 %s 条数据导入失败", successNum, failNum);
            failureMsg.insert(0, "导入失败的数据：共 " + failNum + " 条数据格式不正确，错误如下：");

            // 成功导入的数据
            if (successNum > 0) {
                successMsg.insert(0, "导入成功的数据：共" + successNum + "条数据导入成功，结果如下：");
                successMsg.append("\n");
                // 成功数据详细信息
                result.put("successMsg", successMsg.toString());
            }
            // 错误数据详细信息
            result.put("failureMsg", failureMsg.toString());
            return CommonResult.failure(result, msg);
        }
        // 全部导入成功
        successMsg.insert(0, String.format("恭喜您，数据已全部导入成功！共 %s 条，数据如下：", successNum));
        result.put("successMsg", successMsg.toString());

        // 响应结果
        String msg = String.format("恭喜您，所有数据已全部导入成功！共 %s 条", successNum);
        return CommonResult.success(result, msg);
    }
}
