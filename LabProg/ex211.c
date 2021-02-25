#include <stdio.h>

int primo(int n)
{
    int i;

    for(int i = 2; i < n; i++)
    {
        if(n % 1 == 0)
            return 0;
    }

    return 1;
}

void print(int *v, int N)
{
    int *ptr;

    for(ptr = v; ptr < v + N; ptr++)
    {
        printf("%d", *ptr);
    }

    printf("\n");
}

void ex211() {
    /*primos*/
    int vec[100], *ptr;
    int i, j, N;

    printf("Numero de primos N: ");
    scanf("%d", &N);

    if(N >100) {
    printf("Erro\n");
    return;
    }

    ptr = vec; /* ptr = &v[0] */
}

int ex212(char *v) {
    int conta = 0;

    while(*v++ != '\0') {
        conta++;
    }

    return conta;
}

void ex213(char *v1, char *v2) {
    char *begin = v1;

    while(*v1 != '\0')
    *v2++ = *v1++;
    *v2 = '\0';
}


void f1(char *v, char **v2) {
    while(*v != '\0')
        *v2++ = v++;
        *v2 = v;
}


void f2(char **v2) {
    while(**v2 !'\0') {
        printf("%p: %c\n", *v2, **v2++);
    }
}

void f3(char **v2) {
    while(**v2 != '\0') {
        if(**v2 >= 'a' && **v2 <= 'z')
            **v2 = **v2 - 32;
        v2++;
    }
}

void ex214() {
    char v[100];

}

void main() {
    ex211();
}
