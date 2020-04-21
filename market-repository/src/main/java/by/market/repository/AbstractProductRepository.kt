package by.market.repository

import by.market.domain.AbstractProduct
import by.market.domain.system.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.query.Param
import java.util.*

@NoRepositoryBean
interface AbstractProductRepository<T: AbstractProduct> : BaseRepository<T> {

    fun existsByTitle(title: String): Boolean

    fun findByTitle(title: String): T

    fun countAllByCategory(category: Category): Long

    fun findByCategory_Id(category: UUID, pageable: Pageable): Page<T>

    @Query("select p.id from #{#entityName} p inner join p.category c where c.id IN (:id_categories)")
    fun getAllIdsByCategoryIds(@Param("id_categories") categoryIds: List<UUID>): List<UUID>

}
