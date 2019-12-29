package by.market.config

import by.market.parser.AccessoriesEntitiesToDbEntity
import by.market.parser.CorniceEntitiesToDbEntity
import by.market.parser.JalosieEntitiesToDbEntity
import by.market.parser.RolstorEntitiesToDbEntity
import kotlinx.coroutines.runBlocking
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
        if (env.activeProfiles.any{ it == "prod" || it == "dev"}) {
            log.info("Start ApplicationRunner with args: ", args)
            runBlocking {
                arrayOf(corniceSync, jalosieSync, rolstorSync, accessoriesSync)
                        .forEach {
                            try {
                                it.process()
                            }catch (e: Exception){
                                log.error("Type[${it::javaClass.name}] Ex[$e]")
                            }
                        }
            }

            log.info("Data was loaded")
        }else{
            log.info("Skip initialization database")
        }
    }

}
