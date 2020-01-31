package by.market.repository

import org.jinq.jpa.JPAJinqStream
import org.jinq.jpa.JinqJPAStreamProvider
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

abstract class BaseJinqRepositoryImpl<T>() {

    private var jdp: JinqJPAStreamProvider? = null
        @Autowired set(value) {
            field = value
        }

    private var entityManager: EntityManager? = null
        @PersistenceContext set(value) {
            field = value
        }

    protected abstract fun entityType(): Class<T>

    fun stream(): JPAJinqStream<T> {
        return streamOf(entityType());
    }

    private fun streamOf(clazz: Class<T>): JPAJinqStream<T> {
        return jdp!!.streamAll(entityManager, clazz)
    }
}
