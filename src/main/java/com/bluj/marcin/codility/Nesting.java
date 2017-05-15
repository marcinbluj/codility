package com.bluj.marcin.codility;

import java.util.Stack;

/**
 * Created by MSI on 15.05.2017.
 */
public class Nesting {
    public int solution(String S) { //100%
        // write your code in Java SE 8
        if (S.isEmpty()) {
            return 1;
        }

        if (S.length() % 2 != 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty()) {
                        return 0;
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
            }
        }
        return (stack.empty()) ? 1 : 0;
    }
}
