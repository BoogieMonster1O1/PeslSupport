package io.github.boogiemonster1o1.peslsupport

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object PeslLanguageFileType : LanguageFileType(PeslLanguage) {
    override fun getName(): String = "Pesl File"

    override fun getDescription(): String = "Ponki's epic scripting language"

    override fun getDefaultExtension(): String = "pesl"

    override fun getIcon(): Icon = PeslLanguage.icon
}
