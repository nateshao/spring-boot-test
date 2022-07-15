package com.nateshao.rabbitmq.constant;

/**
 * @date Created by 邵桐杰 on 2022/4/27 10:57
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:  RabbitMQ常量池
 */
public interface RabbitConsts {
    /**
     * 直接模式1
     */
    String DIRECT_MODE_QUEUE_ONE = "queue.direct.1";

    /**
     * 队列2
     */
    String QUEUE_TWO = "queue.2";

    /**
     * 队列3
     */
    String QUEUE_THREE = "3.queue";

    /**
     * 分列模式
     */
    String FANOUT_MODE_QUEUE = "fanout.mode";

    /**
     * 主题模式
     */
    String TOPIC_MODE_QUEUE = "topic.mode";

    /**
     * 路由1
     */
    String TOPIC_ROUTING_KEY_ONE = "queue.#";

    /**
     * 路由2
     */
    String TOPIC_ROUTING_KEY_TWO = "*.queue";

    /**
     * 路由3
     */
    String TOPIC_ROUTING_KEY_THREE = "3.queue";

    /**
     * 延迟队列
     */
    String DELAY_QUEUE = "delay.queue";

    /**
     * 延迟队列交换器
     */
    String DELAY_MODE_QUEUE = "delay.mode";
}

