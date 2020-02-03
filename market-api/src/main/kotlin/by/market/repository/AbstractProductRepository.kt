package by.market.repository

import by.market.domain.AbstractProduct
import by.market.domain.system.Category
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.query.Param
import java.util.*

@NoRepositoryBean
interface AbstractProductRepository<T: AbstractProduct> : BaseRepository<T> {
    fun existsByTitle(title: String): Boolean
    fun findByTitle(title: String): T
    fun findByCategory(category: Category): List<T>

    @Query("select p.id from #{#entityName} p where p.id_category = :id_category")
    fun getAllIdsByCategoryId(@Param("id_category") categoryId: UUID): List<UUID>
}
