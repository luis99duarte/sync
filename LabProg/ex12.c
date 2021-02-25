#include <stdio.h>
#include <stdlib.h>

void ex12();

void ex12() {
    int first, end;

    printf("First year and Last year; ");
    scanf("%d %d", &first, &end);

    int temp;
    int res;

    temp = first % 4;

    if(temp == 0) {
        res = first;
    }

    else if(temp == 1) {
        res = first + 3;
    }

    else if(temp == 2) {
        res = first + 2;
    }

    else {
        res = first + 1;
    }

    printf("%d\n", res);

    while(res <= end) {
        res +=4;
        if(res <= end) {
            printf("%d\n", res);
        }
    }
}

void main() {
    ex12();
}
