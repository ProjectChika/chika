package moe.chika.app.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor

enum class FlavorDimension {
  CONTENT_TYPE
}

enum class Flavor(val dimension: FlavorDimension, val applicationIdSuffix: String? = null) {
  PREVIEW(FlavorDimension.CONTENT_TYPE, applicationIdSuffix = ".preview"),
  STABLE(FlavorDimension.CONTENT_TYPE)
}

fun configureFlavors(
  commonExtension: CommonExtension<*, *, *, *, *>,
  flavorConfigurationBlock: ProductFlavor.(flavor: Flavor) -> Unit = {}
) {
  commonExtension.apply {
    flavorDimensions += FlavorDimension.CONTENT_TYPE.name
    productFlavors {
      Flavor.values().forEach {
        create(it.name.lowercase()) {
          dimension = it.dimension.name
          flavorConfigurationBlock(this, it)
          if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
            if (it.applicationIdSuffix != null) {
              applicationIdSuffix = it.applicationIdSuffix
            }
          }
        }
      }
    }
  }
}
