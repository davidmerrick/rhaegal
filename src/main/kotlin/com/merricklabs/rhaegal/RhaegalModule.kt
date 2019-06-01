package com.merricklabs.rhaegal

import com.merricklabs.rhaegal.external.slack.SlackNotifier
import com.merricklabs.rhaegal.handlers.SnsHandlerLogic
import com.merricklabs.rhaegal.util.RhaegalObjectMapper
import org.koin.dsl.module.module

val RhaegalModule = module {
    single { SnsHandlerLogic() }
    single { RhaegalConfig() }
    single { RhaegalObjectMapper() }
    single { SlackNotifier() }
}