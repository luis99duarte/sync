#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <ctype.h>
#include "teste1.h"
#include "teste1.c"

int main(int argc, char const *argv[]) {
    creatTable();
    Word teste;
    Word teste1;
    Word teste2;
    Word teste3;
    Word teste4;
    teste.index = 223;
    teste.key = "Portugal";
    insertTable(teste);
    teste4.key = "Porto";
    teste4.index = 225;
    insertTable(teste4);
    teste1.index = 225;
    teste1.key = "Lisboa";
    insertTable(teste1);
    teste2.index = 225;
    teste2.key = "Lisboa";
    insertTable(teste2);
    teste3.index = 225;
    teste3.key = "Lisboa";
    insertTable(teste3);
    Word final = searchIndex(225);
    printf("%d", final.count);

    return 0;
}