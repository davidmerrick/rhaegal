package com.merricklabs.rhaegal

import org.koin.standalone.KoinComponent

class RhaegalConfig : KoinComponent {
    val slack = Slack()

    inner class Slack {
        val webhookUri: String = System.getenv("SLACK_WEBHOOK_URI")
    }
}