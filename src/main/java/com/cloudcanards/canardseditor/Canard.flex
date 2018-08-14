package com.cloudcanards.canardseditor;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.cloudcanards.canardseditor.psi.CanardTypes;
import com.intellij.psi.TokenType;

%%

%class CanardLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

AT=@
NAME=[A-Z][^\s(]*
SINGLE_SPACE=[ \t]
SPACE={SINGLE_SPACE}+
OPTIONAL_SPACE={SINGLE_SPACE}*
COMMENT=#.*
CRLF=\R

WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

%state AFTER_AT
%state AFTER_NAME
%state ON_EMOTION
%state ON_TEXT

%%

<YYINITIAL> {
     {AT} {
          yybegin(AFTER_AT);
          return CanardTypes.AT;
      }

     {COMMENT} {
               yybegin(YYINITIAL);
               return CanardTypes.COMMENT;
       }

      {SPACE} {
          yybegin(YYINITIAL);
          return TokenType.WHITE_SPACE;
      }

      . {
          yybegin(ON_TEXT);
      }
}

<AFTER_AT> {
    {NAME} {
          yybegin(AFTER_NAME);
          return CanardTypes.NAME;
      }

    . {
          yybegin(AFTER_NAME);
          return TokenType.BAD_CHARACTER;
      }
}

<AFTER_NAME> \( {
          yybegin(ON_EMOTION);
          return CanardTypes.LEFT_PAREN;
      }

<ON_EMOTION> \w+ {
          yybegin(ON_EMOTION);
          return CanardTypes.EMOTION;
      }

<ON_EMOTION> \) {
          yybegin(ON_TEXT);
          return CanardTypes.RIGHT_PAREN;
      }

<ON_EMOTION> {SPACE} {
          yybegin(ON_TEXT);
          return TokenType.WHITE_SPACE;
      }

<AFTER_NAME> {SPACE} {
          yybegin(ON_TEXT);
          return TokenType.WHITE_SPACE;
      }

<ON_EMOTION> . {
          yybegin(ON_TEXT);
          return TokenType.BAD_CHARACTER;
      }

<AFTER_NAME> . {
          yybegin(ON_TEXT);
          return TokenType.BAD_CHARACTER;
      }

<ON_TEXT> {
    \\\\ {
          yybegin(ON_TEXT);
          return CanardTypes.SPECIAL_CHAR;
      }

    \\# {
          yybegin(ON_TEXT);
          return CanardTypes.SPECIAL_CHAR;
      }

    \\@ {
          yybegin(ON_TEXT);
          return CanardTypes.SPECIAL_CHAR;
      }

    \\{CRLF} {
          yybegin(ON_TEXT);
          return CanardTypes.SPECIAL_CHAR;
      }

    .+ {
          yybegin(ON_TEXT);
          return CanardTypes.TEXT;
      }

    {CRLF}+ {
          yybegin(YYINITIAL);
          return TokenType.WHITE_SPACE;
      }
}

{COMMENT} {
          yybegin(YYINITIAL);
          return CanardTypes.COMMENT;
      }

\s+ {
          yybegin(YYINITIAL);
          return TokenType.WHITE_SPACE;
      }

. {
          yybegin(YYINITIAL);
          return TokenType.BAD_CHARACTER;
      }