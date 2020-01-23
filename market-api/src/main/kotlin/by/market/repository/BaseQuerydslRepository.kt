package by.market.repository

import by.market.domain.BaseEntity
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseQuerydslRepository <T: BaseEntity>
    : BaseRepository<T>,
        QuerydslPredicateExecutor<T> {
}
