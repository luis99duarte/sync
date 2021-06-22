#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <ctype.h>
#include "teste1.h"

void creatTable() {
    tab = malloc(M*sizeof(list));
    for(int i=0; i<M; i++) {
        tab[i] = NULL;
    }
}

void insertTable(Word word) {
    int h,v;
    v = word.index;
    list new = tab[v];
    for (new = tab[v]; new != NULL; new = new->next) {
        if(strcmp(new->obj.key, word.key) == 0 ) {
            break;
        }
    }
    if(new != NULL) {
        new->obj.count ++; 
    }
    else {
        word.count = 1;
        list in = malloc(sizeof(ListNode));
        in->obj = word;
        in->next = tab[v];
        tab[v] = in;
    }
}

Word searchIndex(int index) {
    list t;
    Word a;
    for(t= tab[index]; t != NULL ; t = t->next) {
        if(t->obj.index == index) break;
    }
    if(t!=NULL) return t->obj;
    return a;
}