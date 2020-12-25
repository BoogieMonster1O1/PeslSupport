package io.github.boogiemonster1o1.peslsupport;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static io.github.boogiemonster1o1.peslsupport.psi.PeslTypes.*;

%%

%{
  public PeslLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class PeslLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

WHITE_SPACE=[ \t\n\x0B\f\r]+
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "\""               { return DOUBLE_QUOTE; }
  "function"         { return FUNCTION; }
  "true"             { return TRUE; }
  "false"            { return FALSE; }
  "null"             { return NULL; }
  "undefined"        { return UNDEFINED; }
  "return"           { return RETURN; }
  "throw"            { return THROW; }
  "if"               { return IF; }
  "else"             { return ELSE; }
  "for"              { return FOR; }
  "foreach"          { return FOREACH; }
  "let"              { return LET; }
  "try"              { return TRY; }
  "catch"            { return CATCH; }

  {WHITE_SPACE}      { return WHITE_SPACE; }
  {IDENTIFIER}       { return IDENTIFIER; }

}

[^] { return BAD_CHARACTER; }
