package interpreter;

public interface Constants extends ScannerConstants, ParserConstants
{
    int EPSILON  = 0;
    int DOLLAR   = 1;

    int t_SHOW = 2;
    int t_LOG = 3;
    int t_VARIABLE = 4;
    int t_NUMBER = 5;
    int t_ADD = 6;
    int t_SUBTRACT = 7;
    int t_MULTIPLY = 8;
    int t_DIVIDE = 9;
    int t_EXPONENTIATION = 10;
    int t_EQUAL = 11;
    int t_OPEN_PAREN = 12;
    int t_CLOSE_PAREN = 13;
    int t_EOL = 14;
}
