#ifndef DATA_H_INCLUDED
#define DATA_H_INCLUDED

typedef struct date {
int day;
int month;
int year;
} Date;

typedef struct card {
    int id;
    Date creatDate;
    char* title;
    char* name;
    int state;
    int priority;
    Date deadline;
} Card;


#endif // DATA_H_INCLUDED
