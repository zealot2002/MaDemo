package com.credithc.module_goods.constant;

public class HttpConstant {
    public static final int SUCCESS = 200;

    public static final String EMPTY_DATA_ERROR = "server return:empty";/**服务器返回空**/
    public static final String HTTP_ERROR = "Http errCode:";/**服务器返回错误码**/
    public static final String HTML_DATA_PRE = "<!DOCTYPE html PUBLIC ";/**服务器返回了一个html页**/
    public static final String HTML_DATA_ERROR = "server return: <!DOCTYPE html PUBLIC... ";/**服务器返回了一个html页**/

    public static final String HTTP_METHOD_GET = "get";
    public static final String HTTP_METHOD_POST = "post";
    public static final String HTTP_METHOD_PUT = "put";
    public static final String HTTP_METHOD_DEL = "del";

	public static final String SERVER_URL = "http://172.30.13.194:3000";

    public static final String GET_GOODS_LIST = "goodsList";
}
