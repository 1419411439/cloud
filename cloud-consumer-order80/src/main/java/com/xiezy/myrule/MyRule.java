package com.xiezy.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRule extends AbstractLoadBalancerRule {

    private AtomicInteger nextServerCyclicCounter;

    public MyRule() {
        nextServerCyclicCounter = new AtomicInteger(0);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    /**
     * 注解掉的部分是模仿轮询算法，也就是RoundRobinRule类的实现逻辑
     * 这里为了做测试，只选择用8001的服务
     * @param lb
     * @param key
     * @return
     */
    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                upList.forEach(System.out::println);

                for(Server svr : upList) {
                    if (svr.getPort() == 8001) {
                        server = svr;
                        break;
                    }
                }
            }

//                int index = this.incrementAndGetModulo(serverCount);
//                server = (Server)upList.get(index);
//                if (server == null) {
//                    Thread.yield();
//                } else {
//                    if (server.isAlive()) {
//                        return server;
//                    }
//
//                    server = null;
//                    Thread.yield();
//                }
//            }

            return server;
        }
    }

    /**
     * 自旋锁获取下个坐标
     * @param modulo
     * @return
     */
    private int incrementAndGetModulo(int modulo) {
        int count;
        int next;

        do {
            count = this.nextServerCyclicCounter.get();
            next = count >= Integer.MAX_VALUE ? 0 : count + 1;
        } while (!this.nextServerCyclicCounter.compareAndSet(count, next));

        return next;
    }
}
