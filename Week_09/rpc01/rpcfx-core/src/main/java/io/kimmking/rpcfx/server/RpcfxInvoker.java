package io.kimmking.rpcfx.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResolver;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.kimmking.rpcfx.exception.DescribeException;
import io.kimmking.rpcfx.exception.ResultUtil;
import io.kimmking.rpcfx.exception.RpcfxException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class RpcfxInvoker {

    private RpcfxResolver resolver;

    public RpcfxInvoker(RpcfxResolver resolver) {
        this.resolver = resolver;
    }

    public RpcfxResponse invoke(RpcfxRequest request) {
        RpcfxResponse response = new RpcfxResponse();
        String serviceClass = request.getServiceClass();

        // 作业1：改成泛型和反射 拿到bean
        Object service = resolver.resolve(serviceClass);//this.applicationContext.getBean(serviceClass);

        try {
            Method method = resolveMethodFromClass(service.getClass(), request.getMethod());
            Object result = method.invoke(service, request.getParams()); // dubbo, fastjson,
            //Object result = method.invoke(new Object(), request.getParams()); // dubbo, fastjson,

            // 两次json序列化能否合并成一个
            //response.setResult(ResultUtil.success(JSON.toJSONString(result, SerializerFeature.WriteClassName)));
            response.setResult(JSON.toJSONString(result, SerializerFeature.WriteClassName));
            //response.setException(new IllegalAccessException());
            //response.setStatus(false);
            response.setStatus(true);
            System.out.println("response.getResult():" + response.toString());
            return response;
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {

            // 3.Xstream

            // 2.封装一个统一的RpcfxException
            // 客户端也需要判断异常
            //e.printStackTrace();
            response.setResult(new RpcfxException().exceptionGet(e));
            response.setException(e);
            response.setStatus(false);
            return response;
        }
    }

    private Method resolveMethodFromClass(Class<?> klass, String methodName) {
        return Arrays.stream(klass.getMethods()).filter(m -> methodName.equals(m.getName())).findFirst().get();
    }

}
