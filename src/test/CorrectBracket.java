package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CorrectBracket {
    public static Stack<String> stack;
    public static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String[] pars1 = {"{[]()}", "({()})", "[{}(()]", "[{()}}{]", "{(})"};
        int[] res1 = solution(pars1);

        String[] pars2 = {"[(){{()}}]", "([])", "[()]()[{}]", "(}", "{}", "[]", "()"};
        int[] res2 = solution(pars2);

        for (int r : res1) {
            System.out.print(r + " ");
        }

        System.out.println();

        for (int r : res2) {
            System.out.print(r + " ");
        }
    }

    public static boolean leftCheck(String br) {
        if (stack.empty())
            stack.push(br);

        int preBr = map.get(stack.peek());
        int curBr = map.get(br);

        if (preBr >= curBr) {
            stack.push(br);
            return true;
        }

        return false;
    }

    public static boolean rightCheck(String br) {
        if (stack.empty())
            return false;

        int pop = map.get(stack.pop());
        int cur= map.get(br);
        if (pop == cur)
            return true;

        return false;
    }

    public static int[] solution(String[] pars) {

        int[] res = new int[pars.length];

        map.put("[", 3);
        map.put("{", 2);
        map.put("(", 1);

        map.put("]", 3);
        map.put("}", 2);
        map.put(")", 1);

        for (int i = 0; i < pars.length; i++) {
            String branks = pars[i];
            boolean flag = true;
            stack = new Stack<>();

            for (int j = 0; j < branks.length() && flag == true; j++) {
                String br = branks.substring(j, j + 1);

                switch (br) {
                    case "[":
                    case "{":
                    case "(":
                        if (!leftCheck(br)) {
                            flag = false;
                        }
                        break;

                    case "]":
                    case "}":
                    case ")":
                        if (!rightCheck(br)) {
                            flag = false;
                        }
                    default:
                }
            }

            if (flag) res[i] = 1;
            else res[i] = 0;
        }

        return res;
    }
}


    // 다른 풀이법

//    public static int[] solution (String[] pars) {
//        // 0,  1,  2
//        String[] left = {"[", "{", "("};
//        int[] answer = new int[pars.length];
//        int cnt=0;
//        int pre=0;
//        Stack<String> stack = new Stack<>();
//
//        for (String par : pars) {
//
//            int i=1;
//            stack.push(String.valueOf(par.charAt(0)));
//
//            for (; i<par.length(); i++) {
//                boolean flag = true;
//                String s = String.valueOf(par.charAt(i));
//                String t=stack.lastElement();
//
//                switch (s) {
//                    case "[":
//
//                        if (t.equals("["))
//                            stack.push(s);
//                        else
//                            flag = false;
//
//                        break;
//                    case "{":
//                        if (t.equals("[") || t.equals("{"))
//                            stack.push(s);
//                        else
//                            flag = false;
//
//                        break;
//
//                    case "(":
//                        if (t.equals("[") || t.equals("{") || t.equals("("))
//                            stack.push(s);
//                        else
//                            flag = false;
//                        break;
//
//                    case ")":
//                        if (t.equals("(")) stack.pop();
//                        else flag = false;
//                        break;
//
//                    case "}":
//                        if (t.equals("{")) stack.pop();
//                        else flag = false;
//                        break;
//
//                    case "]":
//                        if (t.equals("]")) stack.pop();
//                        else flag = false;
//                        break;
//
//                    default:
//                        flag = false;
//                        break;
//
//                }
//
//                if (flag == false) {
//                    answer[cnt++] = 0;
//                    break;
//                }
//            }
//
//            if (i==par.length())
//                answer[cnt++] = 1;
//
//        }
//
//        return answer;
//    }


