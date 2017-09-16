package com.gzoltar.core.instr.matchers;

import java.util.regex.Pattern;

public abstract class AbstractMatcher implements IMatcher {

  /**
   * Matches strings against <code>?</code>/<code>*</code> wildcard expressions. Multiple
   * expressions can be separated with a colon (:). In this case the expression matches if at least
   * one part matches.
   */
  public Pattern matches(final String expression) {
    final String[] parts = expression.split("\\:");
    final StringBuilder regex = new StringBuilder(expression.length() * 2);
    boolean next = false;
    for (final String part : parts) {
      if (next) {
        regex.append('|');
      }
      regex.append('(').append(toRegex(part)).append(')');
      next = true;
    }
    return Pattern.compile(regex.toString());
  }

  private static CharSequence toRegex(final String expression) {
    final StringBuilder regex = new StringBuilder(expression.length() * 2);
    for (final char c : expression.toCharArray()) {
      switch (c) {
        case '?':
          regex.append(".?");
          break;
        case '*':
          regex.append(".*");
          break;
        default:
          regex.append(Pattern.quote(String.valueOf(c)));
          break;
      }
    }
    return regex;
  }
}
