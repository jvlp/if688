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
\> 4  
\> 8  
\> +  
\>> 12  
\> 3  
Exception in thread "main" rpnstacker.UnexpectedCharacter: y  
&nbsp;
#### Exemplo 2  
\
Calc2.stk  
\> 5  
\> 2  
\> +  
\>> 7  
\> -3  
\> +  
\>> 4  
\> 2  
\> *  
\>> 8  
\> 4  
\> 9  
\> -  
\>> -5  
\> 2  
\> /  
\>> -2  
\> -  
\>> 1  