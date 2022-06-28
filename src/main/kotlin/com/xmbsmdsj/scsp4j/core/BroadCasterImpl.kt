package com.xmbsmdsj.scsp4j.core

import reactor.core.publisher.FluxSink
import java.util.LinkedList
import java.util.concurrent.ConcurrentHashMap


class BroadCasterImpl : BroadCaster<String> {

    private val subscribers = ConcurrentHashMap<String, MutableList<FluxSink<String>>>();

    override fun subscribe(topic: String, sink: FluxSink<String>) {
        subscribers.compute(topic) { _, v ->
            if (v == null) {
                LinkedList<FluxSink<String>>()
            } else {
                v.add(sink);
                v;
            }
        }
    }

    override fun publish(topic: String, event: String) {
        subscribers[topic]?.forEach { sink ->
            sink.next(event)
        }
    }
}