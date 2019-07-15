package org.apache.dubbo.rpc.cluster.loadbalance;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;

import java.util.List;

/**
 * @Author: huangqi
 * @Description:
 * @Date: 2019-07-15 17:52
 */
public class HqPracticeLoadBalance extends AbstractLoadBalance {

    private static final Logger logger = LoggerFactory.getLogger(HqPracticeLoadBalance.class);

    public static final String NAME = "hqpractice";

    private static final String BANNER = "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";

    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
        logger.info(BANNER);
        System.out.println(BANNER);
        return invokers.get(0);
    }
}
