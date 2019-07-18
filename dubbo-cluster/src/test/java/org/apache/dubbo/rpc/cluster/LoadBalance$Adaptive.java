package org.apache.dubbo.rpc.cluster;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class LoadBalance$Adaptive implements org.apache.dubbo.rpc.cluster.LoadBalance {

    public org.apache.dubbo.rpc.Invoker select(java.util.List arg0, org.apache.dubbo.common.URL arg1, org.apache.dubbo.rpc.Invocation arg2) throws org.apache.dubbo.rpc.RpcException {
        //参数非空校验，url 和 invocation 是必须的参数
        if (arg1 == null) throw new IllegalArgumentException("url == null");

        org.apache.dubbo.common.URL url = arg1;

        if (arg2 == null) throw new IllegalArgumentException("invocation == null");
        // Invocation 是 Dubbo RPC 调用信息的载体，获取方法名
        String methodName = arg2.getMethodName();
        // URL 是Dubbo的一条配置总线，根据参数获取对应的实现类名称
        String extName = url.getMethodParameter(methodName, "loadbalance", "random");

        if (extName == null)
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.rpc.cluster.LoadBalance) name from url (" + url.toString() + ") use keys([loadbalance])");
        // SPI 获取实现类
        org.apache.dubbo.rpc.cluster.LoadBalance extension = (org.apache.dubbo.rpc.cluster.LoadBalance) ExtensionLoader.getExtensionLoader(org.apache.dubbo.rpc.cluster.LoadBalance.class).getExtension(extName);

        return extension.select(arg0, arg1, arg2);
    }
}