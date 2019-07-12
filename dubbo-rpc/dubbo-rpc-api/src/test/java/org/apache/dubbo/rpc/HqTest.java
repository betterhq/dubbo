package org.apache.dubbo.rpc;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.filter.HqPracticeFilter;
import org.junit.jupiter.api.Test;

/**
 * @Author: huangqi
 * @Description:
 * @Date: 2019-07-12 16:28
 */
public class HqTest {

    @Test
    public void test(){
        ExtensionLoader<Filter> extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);
        Filter filter = extensionLoader.getExtension("hqpractice");
        HqPracticeFilter hqPracticeFilter = (HqPracticeFilter) filter;
        hqPracticeFilter.printBanner();
    }
}
