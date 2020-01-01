package by.market.core

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.function.Function

class ProjectPage<TEntity, TDto>(
        val innerPage: Page<TEntity>,
        val mapper: (TEntity) -> TDto
) : Page<TDto>
{
    override fun hasPrevious(): Boolean = innerPage.hasPrevious()

    override fun getSize(): Int = innerPage.size

    override fun getSort(): Sort = innerPage.sort

    override fun previousPageable(): Pageable = innerPage.previousPageable()

    override fun getNumberOfElements(): Int = innerPage.numberOfElements

    override fun getContent(): MutableList<TDto> = innerPage.content.map { mapper(it) }.toMutableList()

    override fun iterator(): MutableIterator<TDto> = ProjectMutableIterator<TEntity, TDto>(innerPage.iterator(), mapper)

    override fun <U : Any?> map(p0: Function<in TDto, out U>): Page<U> = ProjectPage<TDto, U>(this){p0.apply(it)}

    override fun nextPageable(): Pageable = innerPage.nextPageable()

    override fun hasNext(): Boolean = innerPage.hasNext()

    override fun isFirst(): Boolean = innerPage.isFirst

    override fun hasContent(): Boolean = innerPage.hasContent()

    override fun getTotalPages(): Int = innerPage.totalPages

    override fun isLast(): Boolean = innerPage.isLast

    override fun getTotalElements(): Long = innerPage.totalElements

    override fun getNumber(): Int = innerPage.number
}
