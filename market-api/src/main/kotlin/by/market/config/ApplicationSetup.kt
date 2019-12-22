package by.market.config

import by.market.parser.AccessoriesEntitiesToDbEntity
import by.market.parser.CorniceEntitiesToDbEntity
import by.market.parser.JalosieEntitiesToDbEntity
import by.market.parser.RolstorEntitiesToDbEntity
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class ApplicationSetup(private val jalosieSync: JalosieEntitiesToDbEntity,
                       private val corniceSync: CorniceEntitiesToDbEntity,
                       private val rolstorSync: RolstorEntitiesToDbEntity,
                       private val accessoriesSync: AccessoriesEntitiesToDbEntity,
                       private val env: Environment) : ApplicationRunner {

    private val log = LoggerFactory.getLogger(ApplicationSetup::class.java)

    override fun run(args: ApplicationArguments?) {
        if ("test" !in env.activeProfiles) {
            log.info("Start ApplicationRunner with args: ", args)
            arrayOf(corniceSync, jalosieSync, rolstorSync, accessoriesSync).forEach { it.process() }
            log.info("Data was loaded")
        }
    }

}