package io.github.boogiemonster1o1.peslsupport

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class PeslFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, PeslLanguage) {
	override fun getFileType(): FileType = PeslLanguageFileType

	override fun toString(): String = "Pesl File"
}
