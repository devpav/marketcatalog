package by.market.config

import org.jinq.jpa.JinqJPAStreamProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManagerFactory

@Configuration
class JinqConfiguration {

    @Bean()
    fun jinqDataProvider(entityManagerFactory: EntityManagerFactory): JinqJPAStreamProvider {
        return JinqJPAStreamProvider(entityManagerFactory);
    }

}