package io.github.boogiemonster1o1.peslsupport

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import io.github.boogiemonster1o1.peslsupport.psi.PeslTypes

class PeslParserDefinition : ParserDefinition {
	companion object {
		@JvmStatic
		val whitespaces = TokenSet.create(TokenType.WHITE_SPACE)

		@JvmStatic
		val stringLiterals = TokenSet.create(PeslTypes.DOUBLE_QUOTE)

		@JvmStatic
		val file = IFileElementType(PeslLanguage)
	}

	override fun createLexer(project: Project?): Lexer = PeslLexerAdapter()

	override fun createParser(project: Project?): PsiParser = PeslParser()

	override fun getFileNodeType(): IFileElementType = file

	override fun getCommentTokens(): TokenSet = TokenSet.EMPTY

	override fun getWhitespaceTokens(): TokenSet = whitespaces

	override fun getStringLiteralElements(): TokenSet = stringLiterals

	override fun createElement(node: ASTNode?): PsiElement = PeslTypes.Factory.createElement(node)

	override fun createFile(viewProvider: FileViewProvider): PsiFile = PeslFile(viewProvider)

	override fun spaceExistanceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements = ParserDefinition.SpaceRequirements.MAY
}
