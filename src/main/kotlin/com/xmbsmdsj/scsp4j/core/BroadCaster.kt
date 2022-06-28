package com.xmbsmdsj.scsp4j.core

import reactor.core.publisher.FluxSink

interface BroadCaster<T> {
    fun subscribe(topic: String, sink: FluxSink<T>);
    fun publish(topic: String, event: T);
}