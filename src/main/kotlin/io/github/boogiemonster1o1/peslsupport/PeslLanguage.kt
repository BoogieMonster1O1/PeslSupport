package io.github.boogiemonster1o1.peslsupport

import com.intellij.lang.Language
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object PeslLanguage : Language("Pesl") {
	val icon: Icon = IconLoader.getIcon("/icons/pesl.png", PeslLanguage::class.java)
}
