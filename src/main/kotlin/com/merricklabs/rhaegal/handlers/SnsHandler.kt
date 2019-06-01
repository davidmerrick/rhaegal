package com.merricklabs.rhaegal.handlers

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.merricklabs.rhaegal.RhaegalModule
import org.koin.standalone.StandAloneContext

class SnsHandler : RequestHandler<Map<String, Any>, Unit> {
    private val logic: SnsHandlerLogic

    init {
        StandAloneContext.startKoin(listOf(RhaegalModule))
        logic = SnsHandlerLogic()
    }

    override fun handleRequest(input: Map<String, Any>, context: Context) {
        return logic.handleRequest(input, context)
    }
}