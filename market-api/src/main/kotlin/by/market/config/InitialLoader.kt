package by.market.config

import by.market.core.parser.AccessoriesEntitiesToDbEntity
import by.market.core.parser.CorniceEntitiesToDbEntity
import by.market.core.parser.JalousieEntitiesToDbEntity
import by.market.core.parser.RolstorEntitiesToDbEntity
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service

@Service
class InitialLoader(private val jalousieSync: JalousieEntitiesToDbEntity,
                    private val corniceSync: CorniceEntitiesToDbEntity,
                    private val rolstorSync: RolstorEntitiesToDbEntity,
                    private val accessoriesSync: AccessoriesEntitiesToDbEntity,
                    private val env: Environment) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(InitialLoader::class.java)

    override fun run(vararg args: String?) {
        if (env.activeProfiles.any{ it == "prod" || it == "dev"}) {
            log.warn("Start ApplicationRunner with args: ", args)
            runBlocking {

                // val productSource = ParserAsforosProductSource("json")

                arrayOf(corniceSync, jalousieSync, rolstorSync, accessoriesSync)
                        .forEach {
                            try {
                                log.info("On Before process products {}", it.javaClass)
                                // it.productSource = productSource
                                it.process()
                                log.info("On After process products {}", it.javaClass)
                            }catch (e: Exception){
                                log.error("Type[${it::javaClass.name}]", e)
                            }
                        }
            }
            log.warn("Data was loaded")
        }else{
            log.warn("Skip initialization database")
        }
    }

}