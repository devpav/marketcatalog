package enums

import abstraction.IParserContext

enum class AsforosProductContext : IParserContext {
  Cornice {
    override val productName: String
      get() = "cornice"
    override val pageUri: String
      get() = "https://asforos.by/karnizy"
  },
  Jalosie {
    override val productName: String
      get() = "jalousie"
    override val pageUri: String
      get() = "https://asforos.by/zhalyuzi"
  },
  Rolstor {
    override val productName: String
      get() = "rolstor"
    override val pageUri: String
      get() = "https://asforos.by/rolshtory-rulonnye-shtory"
  },
  MagneticClips {
    override val productName: String
      get() = "magnetic_clips"
    override val pageUri: String
      get() = "https://asforos.by/klipsy-magnitnye"
  },
  Luversa {
    override val productName: String
      get() = "luversa"
    override val pageUri: String
      get() = "https://asforos.by/lyuversy"
  },
  GripsAndHoldersAndHooks {
    override val productName: String
      get() = "grips_holders_hooks"
    override val pageUri: String
      get() = "https://asforos.by/podhvaty-derzhateli-kryuchki"
  },
}
