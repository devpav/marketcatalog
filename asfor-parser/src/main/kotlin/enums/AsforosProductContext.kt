package enums

import abstraction.IParserContext
import dal.ProductCategory

enum class AsforosProductContext(val categoriesArray: Array<ProductCategory>) : IParserContext {
  Cornice(arrayOf(
          ProductCategory("https://asforos.by/metallicheskie-karnizy/", "metallic"),
          ProductCategory("https://asforos.by/potolochnye-karnizy/", "plastic_ceilings"),
          ProductCategory("https://asforos.by/metalloplastikovye-karnizy/", "wall_metal_plastic"),
          ProductCategory("https://asforos.by/komplektuyushhie-dlya-potolochnih-karnizov/", "accessories_for_ceiling"),
          ProductCategory("https://asforos.by/komplektuyush%D1%81hie-dlya-metallicheskih-karnizov/", "accessories_for_metal"),
          ProductCategory("https://asforos.by/gibkie-karnizy/", "flexible"),
          ProductCategory("https://asforos.by/metalloplastikovaya-furnitura/", "metal_plastic_accessories"))) {
    override val productName: String
      get() = "cornice"
    override val categories: Array<ProductCategory>
      get() = categoriesArray
  },
  Jalosie(arrayOf(
          ProductCategory("https://asforos.by/rolshtory-rulonnye-shtory-den-noch/", "day_night"),
          ProductCategory("https://asforos.by/rolshtory-rulonnye-shtory-standart/", "standard"),
          ProductCategory("https://asforos.by/rolshtory-rulonnye-shtory-v-korobe/", "in_box"),
          ProductCategory("https://asforos.by/rolshtory-rulonnye-shtory-premium/", "premium"),
          ProductCategory("https://asforos.by/rolshtory-rulonnye-shtory-blackout/", "blackout"))) {
    override val productName: String
      get() = "jalousie"
    override val categories: Array<ProductCategory>
      get() = categoriesArray
  },
  Rolstor(arrayOf(ProductCategory("https://asforos.by/rolshtory-rulonnye-shtory", "rolstor"))) {
    override val productName: String
      get() = "rolstor"
    override val categories: Array<ProductCategory>
      get() = categoriesArray
  },
  Accessories(arrayOf(
          ProductCategory("https://asforos.by/lyuversy/", "luversa"),
          ProductCategory("https://asforos.by/podhvaty-derzhateli-kryuchki/", "grips_holders_hooks"),
          ProductCategory("https://asforos.by/klipsy-magnitnye/", "magnetic_clips"))) {
    override val productName: String
      get() = "accessories"
    override val categories: Array<ProductCategory>
      get() = categoriesArray
  }
}
