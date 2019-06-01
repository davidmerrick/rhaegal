package com.merricklabs.rhaegal.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

class RhaegalObjectMapper : ObjectMapper() {
    init {
        this.registerModule(KotlinModule())
    }
}