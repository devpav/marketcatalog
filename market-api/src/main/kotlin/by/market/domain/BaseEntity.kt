package by.market.domain

import by.market.domain.converters.DeserializerUUID
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity {

    @Id
    @GenericGenerator(name = "useIdOrGenerate", strategy = "by.vitebsk.market.domain.generator.GeneratorID")
    @GeneratedValue(generator = "useIdOrGenerate")
    @Column(name = "id", nullable = false, unique = true)
    @JsonDeserialize(using = DeserializerUUID::class)
    var id: UUID? = null;

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseEntity) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

}
