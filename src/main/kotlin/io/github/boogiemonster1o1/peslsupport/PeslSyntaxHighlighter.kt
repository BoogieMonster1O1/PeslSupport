package io.github.boogiemonster1o1.peslsupport

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import io.github.boogiemonster1o1.peslsupport.psi.PeslTypes
import java.awt.Color
import java.awt.Font

class PeslSyntaxHighlighter : SyntaxHighlighterBase() {
	companion object {
		private val keywordKey = TextAttributesKey.createTextAttributesKey("PESL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
		private val functionDeclKey = TextAttributesKey.createTextAttributesKey("PESL_FUNCTION_DECLARATION", TextAttributes(Color.YELLOW, null, null, null, Font.PLAIN))
		private val functionCallKey = TextAttributesKey.createTextAttributesKey("PESL_FUNCTION_CALL", TextAttributes(Color(255, 255, 204), null, null, null, Font.PLAIN))
		private val stringKey = TextAttributesKey.createTextAttributesKey("PESL_STRING", TextAttributes(Color(108, 144, 68), null, null, null, Font.PLAIN))
		private val emptyKeys = arrayOf<TextAttributesKey>()
		private val functionDeclKeys = arrayOf(functionDeclKey)
		private val functionCallKeys = arrayOf(functionCallKey)
		private val keywordKeys = arrayOf(keywordKey)
		private val stringKeys = arrayOf(stringKey)
	}

	override fun getHighlightingLexer(): Lexer = PeslLexerAdapter()

	override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
		when (tokenType) {
			PeslTypes.FUNCTION_CALL_NAME, PeslTypes.FUNCTION_INVOCATION -> {
				return functionCallKeys
			}
			PeslTypes.FUNCTION_DECL_NAME, PeslTypes.FUNCTION_DEFINITION -> {
				return functionDeclKeys
			}
			PeslTypes.DOUBLE_QUOTE, PeslTypes.STRING_TEXT -> {
				return stringKeys
			}
			PeslTypes.FUNCTION, PeslTypes.IF, PeslTypes.ELSE, PeslTypes.UNDEFINED, PeslTypes.FOREACH, PeslTypes.LET, PeslTypes.FOR, PeslTypes.THROW, PeslTypes.RETURN, PeslTypes.TRUE, PeslTypes.FALSE, PeslTypes.NULL, PeslTypes.TRY, PeslTypes.CATCH -> {
				return keywordKeys
			}
		}
		return emptyKeys
	}
}
