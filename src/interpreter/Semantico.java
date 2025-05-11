package interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    private Map<String, Integer> variables = new HashMap<>();
    private Stack<Integer> stack = new Stack();
    private String currentVariable;

    public void executeAction(int action, Token token)	throws SemanticError {
        Integer num1, num2;

        switch (action) {
            case 1: // Valores numéricos utilizados nas expressões
                stack.push(Integer.parseInt(token.getLexeme(), 2));
                break;
            case 2: // Adição
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 + num2);
                break;
            case 3: // Multiplicação
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 * num2);
                break;
            case 4: // Variáveis utilizadas nas expressões
                stack.push(variables.get(token.getLexeme()));
                break;
            case 5: // Subtração
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 - num2);
                break;
            case 6: // Divisão
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 / num2);
                break;
            case 7: // Potência
                num2 = stack.pop();
                num1 = stack.pop();
                Double power = Math.pow(num1, num2);
                stack.push(power.intValue());
                break;
            case 8: // Logaritmo
                num1 = stack.pop();
                Double log = Math.log(num1);
                stack.push(log.intValue());
                break;
            case 9: // Show
                System.out.println("Resultado: " + Integer.toBinaryString(variables.get(currentVariable)) + "\n");
                break;
            case 10: // Set
                variables.put(currentVariable, stack.pop());
                break;
            case 11: // Get
                currentVariable = token.getLexeme();
                break;
            default:
                throw new SemanticError("Ação não definida" + action);
        }
    }
}
