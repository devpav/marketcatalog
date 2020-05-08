package by.market.mapper;

import by.market.domain.characteristics.AbstractCharacteristic;
import by.market.dto.characteristics.AbstractCharacteristicDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface CharacteristicValueMapper extends MapstructMapper<AbstractCharacteristicDTO<Object>, AbstractCharacteristic<Object>> {

    @Override
    @Mapping(source = "characteristic.id", target = "characteristic")
    @Mapping(source = "product.id", target = "product")
    AbstractCharacteristicDTO<Object> toMap(AbstractCharacteristic<Object> objectAbstractCharacteristic);

    @Override
    @InheritInverseConfiguration
    AbstractCharacteristic<Object> fromMap(AbstractCharacteristicDTO<Object> objectAbstractCharacteristicDTO);

}
