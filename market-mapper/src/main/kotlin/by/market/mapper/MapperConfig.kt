package by.market.mapper

import org.mapstruct.MapperConfig
import org.mapstruct.ReportingPolicy


@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface MapperConfig {}