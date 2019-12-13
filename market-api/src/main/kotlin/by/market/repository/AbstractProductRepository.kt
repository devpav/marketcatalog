package by.market.repository

import by.market.domain.AbstractProduct
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractProductRepository<T: AbstractProduct> : BaseRepository<T>
