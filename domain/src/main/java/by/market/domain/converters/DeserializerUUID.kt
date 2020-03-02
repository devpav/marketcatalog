package by.market.domain.converters

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.io.IOException
import java.util.*

class DeserializerUUID : JsonDeserializer<UUID>() {
    @Throws(IOException::class)
    override fun deserialize(jsonParser: JsonParser, deserializationContext: DeserializationContext): UUID {
        return UUID.fromString(jsonParser.valueAsString)
    }
}
