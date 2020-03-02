package by.market.repository

import by.market.domain.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface BaseRepository<T: BaseEntity> : JpaRepository<T, UUID>
