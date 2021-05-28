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
  char c;
  int count = 0;

  while ((c = fgetc(fp)) != EOF)
  {
    if (c == ' ' || c == '\n')
    {
      printf("\n");
      ++count;
    }
      if(getKey(c) != 0) {
        printf("%d", getKey(c));
      }
  }

  fclose(fp);

  printf("%d\n", count);      // Number of words
  return 0;
}

int getKey(char letter)
{
  switch (letter)
  {
  case '-':
    return 1;
    // menor que 128
    // igual a 195
  case 'a':
  case 'b':
  case 'c':
  case 'A':
  case 'B':
  case 'C':
    /*case 'á':
  case 'à':
  case 'Á':
  case 'À':
  case 'ã':
  case 'Ã':
  case 'â':
  case 'Â':*/
    return 2;

  case 'd':
  case 'e':
  case 'f':
  case 'D':
  case 'E':
  case 'F':
    /*case 'é':
  case 'É':
  case 'ê':
  case 'Ê': */
    return 3;

  case 'g':
  case 'h':
  case 'i':
  case 'G':
  case 'H':
  case 'I':
    /*case 'í':
  case 'Í':*/
    return 4;

  case 'j':
  case 'k':
  case 'l':
  case 'J':
  case 'K':
  case 'L':
    return 5;

  case 'm':
  case 'n':
  case 'o':
  case 'M':
  case 'N':
  case 'O':
    /* case 'ó':
  case 'Ó':
  case 'õ':
  case 'Õ':
  case 'ô':
  case 'Ô': */
    return 6;

  case 'p':
  case 'q':
  case 'r':
  case 's':
  case 'P':
  case 'Q':
  case 'R':
  case 'S':
    return 7;

  case 't':
  case 'u':
  case 'v':
  case 'T':
  case 'U':
  case 'V':
  case 'Z':
    /* case 'ú':
  case 'Ú': */
    return 8;

  case 'x':
  case 'y':
  case 'z':
  case 'X':
  case 'Y':
    //case 'Z':
    return 9;

  default:
    return 0;
  }
}