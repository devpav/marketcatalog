package by.market.domain.nosql

import by.market.domain.BaseEntity

class ContentPage<T: BaseEntity>(content: MutableList<T>, totalElement: Long, pageIndex: Int, size: Long)
