package org.apache.dubbo.rpc.cluster;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: huangqi
 * @Description:
 * @Date: 2019-07-15 16:23
 */
public class HqClusterTest {

    @Test
    public void test(){
        ExtensionLoader.getExtensionLoader(LoadBalance.class).getAdaptiveExtension();
    }

    @Test
    public void test1(){
        LoadBalance loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getAdaptiveExtension();
        Map map = new HashMap(){
            {
                put("loadbalance", "hqpractice");
            }
        };

        URL url = new URL("dubbo", "anyhost", 8888, map);

        List invokers = new ArrayList(){
            {
                add(new MyInvoker());
                add(new MyInvoker());
                add(new MyInvoker());
            }
        };
        loadBalance.select(invokers, url, new RpcInvocation());
    }

    class MyInvoker implements Invoker{
        @Override
        public Class getInterface() { return null; }
        @Override
        public Result invoke(Invocation invocation) throws RpcException { return null; }
        @Override
        public URL getUrl() { return null; }
        @Override
        public boolean isAvailable() { return false; }
        @Override
        public void destroy() {}
    }
}
