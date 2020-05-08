package by.market.mapper;

import by.market.domain.characteristics.single.DoubleCharacteristic;
import by.market.dto.characteristics.DoubleCharacteristicDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface DoubleCharacteristicMapper extends MapstructMapper<DoubleCharacteristicDTO, DoubleCharacteristic> {

    @Override
    @Mapping(source = "characteristic.id", target = "characteristic")
    @Mapping(source = "product.id", target = "product")
    DoubleCharacteristicDTO toMap(DoubleCharacteristic objectAbstractCharacteristic);

    @Override
    @InheritInverseConfiguration
    DoubleCharacteristic fromMap(DoubleCharacteristicDTO objectAbstractCharacteristicDTO);

}
