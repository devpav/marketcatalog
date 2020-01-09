package by.market.mapper

import java.util.*

class CharPair {
    var multipleStringChar: List<CharDescription<String>> = mutableListOf()
    var multipleDoubleChar: List<CharDescription<Double>> = mutableListOf()
}

class CharDescription<T>{
    var id: UUID? = null
    var title: String? = null
    var value: List<T>? = null
}
