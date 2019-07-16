package org.apache.dubbo.rpc;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;

/**
 * @Author: huangqi
 * @Description:
 * @Date: 2019-07-16 15:53
 */
public class HqRpcDubboTest {

    @Test
    public void test(){
        ExtensionLoader<Protocol> extensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);
        Protocol protocol = extensionLoader.getExtension("dubbo");
        System.out.println(protocol);
    }
}
