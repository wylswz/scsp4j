package com.xmbsmdsj.scsp4j.rest

import com.xmbsmdsj.scsp4j.core.BroadCasterImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/scsp/stream")
@EnableScheduling
class SCSPController {

    @Autowired
    lateinit var broadCaster: BroadCasterImpl

    @PostMapping(path = ["/subscribe"])
    fun subscribe(@RequestParam("topic") topic: String): Flux<String> {
        return Flux.create() {sink -> broadCaster.subscribe(topic, sink)}
    }


}