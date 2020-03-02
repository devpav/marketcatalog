package by.market.dto.characteristics

data class CharacteristicPairDTO(val stringCharacteristicDTO: List<CharacteristicDescriptionDTO<String>>,
                                 val doubleCharacteristicDTO: List<CharacteristicDescriptionDTO<Double>>)
