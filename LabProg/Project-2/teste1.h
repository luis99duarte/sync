#ifndef HASH_H_INCLUDED
#define HASH_H_INCLUDED
#define M 9999

typedef char *string;

typedef struct
{
    int index;
    string key;
    int count;
} Word;

//Definição de um nó das listas de colisões.
typedef struct lnode *list;
struct lnode
{
    Word obj;
    list next;
} ListNode;

list *tab;
#endif

int getKey(unsigned char *word, int i);

int getIndex(unsigned char *word);

void insertTable(Word word);

Word searchIndex(int index);

void creatTable();

void readFile(char *fp);

string searchWord(int x);

void t9(int x);