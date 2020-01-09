package by.market.mapper.dto.characteristics

data class FrontEndCharacteristicPair(val stringCharacteristic: List<FrontEndCharacteristicDescription<String>>,
                                      val doubleCharacteristic: List<FrontEndCharacteristicDescription<Double>>)
