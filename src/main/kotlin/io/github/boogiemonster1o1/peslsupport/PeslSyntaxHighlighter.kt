package io.github.boogiemonster1o1.peslsupport

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import io.github.boogiemonster1o1.peslsupport.psi.PeslTypes

class PeslSyntaxHighlighter : SyntaxHighlighterBase() {
	companion object {
		private val keywordKey = TextAttributesKey.createTextAttributesKey("PESL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
		private val functionDeclKey = TextAttributesKey.createTextAttributesKey("PESL_FUNCTION_DECLARATION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
		private val functionCallKey = TextAttributesKey.createTextAttributesKey("PESL_FUNCTION_CALL", DefaultLanguageHighlighterColors.FUNCTION_CALL)
		private val stringKey = TextAttributesKey.createTextAttributesKey("PESL_STRING", DefaultLanguageHighlighterColors.STRING)
		private val emptyKeys = arrayOf<TextAttributesKey>()
		private val functionDeclKeys = arrayOf(functionDeclKey)
		private val functionCallKeys = arrayOf(functionCallKey)
		private val stringKeys = arrayOf(stringKey)
	}

	override fun getHighlightingLexer(): Lexer = PeslLexerAdapter()

	override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
		when (tokenType) {
			PeslTypes.FUNCTION_CALL_NAME -> {
				return functionCallKeys
			}
			PeslTypes.FUNCTION_DECL_NAME -> {
				return functionDeclKeys
			}
			PeslTypes.STRING -> {
				return stringKeys
			}
			PeslTypes.FUNCTION, PeslTypes.IF, PeslTypes.ELSE, PeslTypes.UNDEFINED, PeslTypes.FOREACH, PeslTypes.LET, PeslTypes.FOR, PeslTypes.THROW, PeslTypes.RETURN, PeslTypes.BOOLEAN, PeslTypes.NULL, PeslTypes.TRY, PeslTypes.CATCH -> {

			}
		}
		return emptyKeys
	}
}
