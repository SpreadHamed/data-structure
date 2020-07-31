package com.hamed;

import java.util.*;

public class Expression {
    private final String expression;
    List<Character> leftBracket = Arrays.asList('(', '[', '{', '<');
    List<Character> rightBracket = Arrays.asList(')', ']', '}', '>');

    public Expression(String expression) {
        this.expression = expression;
    }

    public boolean isBalanced() {
        var stack = new Stack<Character>();
        for (char ch : expression.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);
            else if (isRightBracket(ch)) {
                if (stack.isEmpty())
                    return false;

                if (!isBracketMatch(stack.pop(), ch))
                    return false;
            }

        }

        return stack.isEmpty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBracket.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBracket.contains(ch);
    }

    private boolean isBracketMatch(char left, char right) {
        return leftBracket.indexOf(left) == rightBracket.indexOf(right);
    }
}
