package com.merricklabs.rhaegal.handlers

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.merricklabs.rhaegal.external.slack.SlackNotifier
import com.merricklabs.rhaegal.util.RhaegalObjectMapper
import mu.KotlinLogging
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

private val log = KotlinLogging.logger {}

class SnsHandlerLogic : RequestHandler<Map<String, Any>, Unit>, KoinComponent {
    private val mapper: RhaegalObjectMapper  by inject()
    private val slackNotifier: SlackNotifier  by inject()

    override fun handleRequest(input: Map<String, Any>, context: Context) {
        log.info("Received request")
        log.info(mapper.writeValueAsString(input))

        // Todo: For now just using this for doorbell notifications. Make a schema to make this more flexible.
        try {
            slackNotifier.notify("Buzzed someone in")
        } catch (e: Exception){
            log.error("Error posting Slack notification", e)
        }
    }
}

