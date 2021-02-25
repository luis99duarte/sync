#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int dia, mes, ano;
} Data;

int compara(const void *date1, const void *date2) {
    int data1 = ((Data*)date1)->ano*100 + ((Data*)date1)->mes*100 + ((Data*)date1)->dia;
    int data2 = ((Data*)date2)->ano*100 + ((Data*)date2)->mes*100 + ((Data*)date2)->dia;

    if(data1 == data2) return 0;
    else if(data1 > data2) return 1;
    else return -1;
}
