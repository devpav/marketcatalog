package by.market.config

import by.market.parser.CorniceEntitiesToDbEntity
import by.market.parser.JalosieEntitiesToDbEntity
import by.market.parser.RolstorEntitiesToDbEntity
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApplicationSetup : ApplicationRunner {

    private val log = LoggerFactory.getLogger(ApplicationSetup::class.java)

    private lateinit var corniceSync: CorniceEntitiesToDbEntity
    private lateinit var jalosieSync: JalosieEntitiesToDbEntity
    private lateinit var rolstorSync: RolstorEntitiesToDbEntity

    override fun run(args: ApplicationArguments?) {
        log.info("Start ApplicationRunner with args: ", args)
        arrayOf(corniceSync, jalosieSync, rolstorSync).forEach {
            it.process()
        }
        log.info("Data was loaded")
    }

}