package by.market.repository

import org.jinq.jpa.JPAJinqStream
import org.jinq.jpa.JinqJPAStreamProvider
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

abstract class BaseJinqRepositoryImpl<T> {
    @Autowired
    private lateinit var jinqDataProvider: JinqJPAStreamProvider

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    protected abstract fun entityType(): Class<T>;

    fun stream(): JPAJinqStream<T> {
        return streamOf(entityType());
    }

    protected  fun <U> streamOf(clazz: Class<U>): JPAJinqStream<U> {
        return jinqDataProvider.streamAll(entityManager, clazz);
    }
}
