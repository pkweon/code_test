import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostfixCalculator {
    public long solution(String[] p) {
        List<String> stack = new ArrayList<>();
        long answer = 0;
        for (String expr : p) {
            switch (expr) {
                case "+":
                case "-":
                case "*":
                case "/":
                    String a = stack.remove(stack.size()-1);
                    String b = stack.remove(stack.size()-1);
                    switch(expr) {
                        case "+":
                            stack.add(Long.toString(Long.parseLong(a) + Long.parseLong(b)));
                            break;
                        case "-":
                            stack.add(Long.toString(Long.parseLong(b) - Long.parseLong(a)));
                            break;
                        case "*":
                            stack.add(Long.toString(Long.parseLong(b) * Long.parseLong(a)));
                            break;
                        case "/":
                            stack.add(Long.toString(Long.parseLong(b) / Long.parseLong(a)));
                    }
                    break;
                default:
                    stack.add(expr);
            }
        }
        answer = Long.parseLong(stack.get(stack.size()-1));
        return answer;
    }
}
