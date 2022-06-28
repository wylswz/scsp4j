package com.xmbsmdsj.scsp4j.configuration

import com.xmbsmdsj.scsp4j.core.BroadCasterImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SCSPConfiguration {

    @Bean
    fun broadCaster(): BroadCasterImpl {
        return BroadCasterImpl()
    }
}