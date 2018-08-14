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
NAME=[A-Z][A-Za-z0-9]*
SINGLE_SPACE=[ \t]
SPACES={SINGLE_SPACE}+
OPTIONAL_SPACE={SINGLE_SPACE}*
COMMENT=#.*
CRLF=\R

%state AFTER_AT
%state AFTER_NAME
%state ON_EMOTION
%state ON_TEXT

%%

<YYINITIAL> {
      \s+ {
          yybegin(YYINITIAL);
          return TokenType.WHITE_SPACE;
      }

     {AT} {
          yybegin(AFTER_AT);
          return CanardTypes.AT;
      }

     {COMMENT} {
               yybegin(YYINITIAL);
               return CanardTypes.COMMENT;
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

    {CRLF} {
          yybegin(YYINITIAL);
          return TokenType.BAD_CHARACTER;
      }
}

<AFTER_NAME> {
    \( {
              yybegin(ON_EMOTION);
              return CanardTypes.EMOTION_LEFT_PAREN;
          }

    {COMMENT} {
              yybegin(YYINITIAL);
              return TokenType.BAD_CHARACTER;
          }

    {SPACES} {
                yybegin(ON_TEXT);
                return TokenType.WHITE_SPACE;
            }

    {CRLF} {
                    yybegin(YYINITIAL);
                    return TokenType.BAD_CHARACTER;
                }
}

<ON_EMOTION> {
    \w+ {
          yybegin(ON_EMOTION);
          return CanardTypes.EMOTION;
      }

      \) {
            yybegin(ON_TEXT);
            return CanardTypes.EMOTION_RIGHT_PAREN;
        }

    {COMMENT} | // use action below

    \s+ {
          yybegin(YYINITIAL);
          return TokenType.BAD_CHARACTER;
      }
}

<ON_TEXT, YYINITIAL> {
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

    [^@\n\r\\#]+ {
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

[^] {
          yybegin(YYINITIAL);
          return TokenType.BAD_CHARACTER;
      }