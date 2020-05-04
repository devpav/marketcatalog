package by.market.config

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service

@Service
@Profile(value = ["prod"])
class InitialLoader(private val env: Environment) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(InitialLoader::class.java)

    override fun run(vararg args: String?) {
        log.warn("Start ApplicationRunner with args: ", args)
    }

}