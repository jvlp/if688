# Compiladores

## Task 1/2 - RPNStacker

entrada consiste no nome do arquivo que deve ser lido.  
o arquivo é composto por uma sequencia de números/operações separadas por uma quebra de linha.  
O caractere "q" ou EOF encerra a execução

### Execução  
&nbsp;  
#### Exemplo 1  
\
Calc1.stk  
Token [type=NUM, lexeme=4]  
\> 4  
Token [type=NUM, lexeme=8]  
\> 8  
Token [type=PLUS, lexeme=+]  
\> +  
Token [type=NUM, lexeme=12]  
\>> 12  
Token [type=NUM, lexeme=3]  
\> 3  
Exception in thread "main" rpnstacker.UnexpectedCharacter: y  
&nbsp;
#### Exemplo 2  
\
Calc2.stk  
Token [type=NUM, lexeme=5]  
\> 5  
Token [type=NUM, lexeme=2]  
\> 2  
Token [type=PLUS, lexeme=+]  
\> +  
Token [type=NUM, lexeme=7]  
\>> 7  
Token [type=NUM, lexeme=-3]  
\> -3  
Token [type=PLUS, lexeme=+]  
\> +  
Token [type=NUM, lexeme=4]  
\>> 4  
Token [type=NUM, lexeme=2]  
\> 2  
Token [type=STAR, lexeme=*]  
\> *  
Token [type=NUM, lexeme=8]  
\>> 8  
Token [type=NUM, lexeme=4]  
\> 4  
Token [type=NUM, lexeme=10]  
\> 10  
Token [type=MINUS, lexeme=-]  
\> -  
Token [type=NUM, lexeme=-6]  
\>> -6  
Token [type=NUM, lexeme=2]  
\> 2  
Token [type=SLASH, lexeme=/]  
\> /  
Token [type=NUM, lexeme=-3]  
\>> -3  
Token [type=MINUS, lexeme=-]  
\> -  
Token [type=NUM, lexeme=11]  
\>> 11  
Token [type=EOF, lexeme=null]  