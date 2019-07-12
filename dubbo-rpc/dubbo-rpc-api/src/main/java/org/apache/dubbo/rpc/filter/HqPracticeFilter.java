package org.apache.dubbo.rpc.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.rpc.*;

/**
 * @Author: huangqi
 * @Description:
 * @Date: 2019-07-12 16:18
 */
@Activate(group = CommonConstants.PROVIDER, value = "hqpractice")
public class HqPracticeFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(HqPracticeFilter.class);

    private static final String BANNER = "    o O O    o O O    o O O    o O O    o O O    o O O    o O O    o O O\n" +
                                        "   o        o        o        o        o        o        o        o\n" +
                                        "  TS__[O]  TS__[O]  TS__[O]  TS__[O]  TS__[O]  TS__[O]  TS__[O]  TS__[O]\n" +
                                        " {======| {======| {======| {======| {======| {======| {======| {======|\n" +
                                        "./o--000'./o--000'./o--000'./o--000'./o--000'./o--000'./o--000'./o--000'";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        printBanner();
        return invoker.invoke(invocation);
    }

    public void printBanner(){
        logger.info(BANNER);
        System.out.println(BANNER);
    }
}
