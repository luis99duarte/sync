#include <iostream>
#include <array>
using namespace std;

int counter(int array[],int N, int k) {
    int count = 0;

    for(int i = 0; i < N; i++) {
        if(array[i] == k) {
            count++;
        }
    }
    return count;
}

int main() {
    int N;

    cin >> N;

    int array[N];

    for(int i = 0; i < N; i++) {
        cin >> array[i];
    }

    cout << counter(array, N, 42) << endl;

    return 0;
}