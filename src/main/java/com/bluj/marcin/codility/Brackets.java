package com.bluj.marcin.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by MSI on 15.05.2017.
 */
public class Brackets {
    public int solution(String S) { //100%
        // write your code in Java SE 8
        if (S.isEmpty()) {
            return 1;
        }
        if (S.length() % 2 != 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        fillMap(brackets);

        for (int i = 0; i < S.length(); i++) {
            char currentBracket = S.charAt(i);
            if (stack.empty()) {
                if (S.charAt(i) == ')' || S.charAt(i) == ']' || S.charAt(i) == '}') {
                    return 0;
                } else {
                    stack.push(currentBracket);
                }
            } else {
                Character peek = stack.peek();
                if (currentBracket == brackets.get(peek)) {
                    stack.pop();
                } else if (brackets.containsKey(currentBracket)) {
                    stack.push(currentBracket);
                } else {
                    return 0;
                }
            }
        }
        return (stack.empty()) ? 1 : 0;
    }

    private void fillMap(Map<Character, Character> brackets) {
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
    }
}
