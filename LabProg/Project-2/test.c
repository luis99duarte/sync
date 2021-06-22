#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

int getKey(char letter);

int main(int argc, char *argv[])
{
  if (argc < 2)
    return 1;
  char *filename = argv[1];
  FILE *fp = fopen(filename, "r");
  if (fp == NULL)
    return 1;
  char c[100];
  unsigned char a;
  //int count = 0;
  while(fgets(c, 100, fp)) {
    int i = 0;
    while(c[i] != '\n') {
      if(c[i] == ' ' || c[i] == '\n' || c[i] == ',' || c[i] == '.' || c[i] == '!' || c[i] == '?') {
        i++;
        printf("\n");
        continue;
      }
      else {
        a = c[i];
        printf("%d ", a);
        i++;
      }
    }
    printf("\n");
  }
    /*if (getKey(c) != 0)
    {
      printf("%d", getKey(c));
    }
  }*/

  fclose(fp);
  return 0;
}