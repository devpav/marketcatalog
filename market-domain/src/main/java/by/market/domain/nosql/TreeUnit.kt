package by.market.domain.nosql

import java.util.*

class TreeUnit {
    public var id: UUID? = null
    public var value: String? = null
    public var description: String? = null
    public var subunits: List<TreeUnit> = mutableListOf()
}
