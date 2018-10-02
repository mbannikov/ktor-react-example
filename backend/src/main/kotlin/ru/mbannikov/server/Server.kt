package ru.mbannikov.server

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.content.resource
import io.ktor.content.resources
import io.ktor.content.static
import io.ktor.features.CallLogging
import io.ktor.routing.routing
import org.slf4j.event.Level
import ru.mbannikov.server.constants.Constants.Companion.RESOURCE_INDEX
import ru.mbannikov.server.constants.Constants.Companion.RESOURCE_STATIC
import ru.mbannikov.server.constants.Constants.Companion.STATIC_ROUTE
import ru.mbannikov.server.constants.Endpoints.Companion.ROOT

fun Application.main() {
    install(CallLogging) {
        level = Level.INFO
    }

    routing {
        static {
            resource(ROOT, RESOURCE_INDEX)

            static(STATIC_ROUTE) {
                resources(RESOURCE_STATIC)
            }
        }
    }
}