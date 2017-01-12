//
//  main.cpp
//  Java_HW1
//
//  Created by Jay Patel.
//  Copyright © 2016 Jay Patel. All rights reserved.
//

#include <iostream>
#include <sstream>
#include <stdlib.h>
#include <time.h>
#include <limits> 
#include <string> 


using namespace std;

const int selectNumOfHeaps [3]= {3,5,7};
const int selectSizeOfHeap [3] = {9,11,13};
int i,j,k;

bool isHeapsEmpty(int [], int);
int main() {
    
    // randomly assign a value of total number of heaps present in the game
    
    srand(time(0));
    int heapIndex = rand() % 3;
    int totalHeaps = selectNumOfHeaps[heapIndex];
    cout<< "Created " << totalHeaps << " heaps of sizes ";
    int heaps [totalHeaps];
    
    // randomly assigns the size of one particular heap
    
    for (i=0; i<totalHeaps; i++){
        
        int sizeIndex = rand() % 3;
        int heapSize = selectSizeOfHeap [sizeIndex];
        heaps [i] =  heapSize;
        cout << heaps[i] << " ";
    }
    cout << endl;
    
    // randomly selecting the turn either computer or human
    
    string selectTurn[2] = {"computer","human"};
    int turnIndex = rand() % 2;
    string turn = selectTurn[turnIndex];
    cout << "Player " << turn << " goes first" << endl;
    
    while(true){
    
        // the computer takes turn in the given Y,X pattern where Y is the number of marbles or units and X is it heap indentifier starting from 1

    
        if (turn == "computer") {
            int heapIndex = rand() % totalHeaps; // heapIndex = btween 0 and totalHeaps-1
            while(heaps[heapIndex] == 0) {
                heapIndex = rand() % totalHeaps;
            }
            cout    << "Player computer took " << heaps[heapIndex]
                    << " objects from heap " << heapIndex+1 << endl;
            heaps[heapIndex] = 0;
            turn = "human";
            if(isHeapsEmpty(heaps,totalHeaps)){
                for (int gameover=0; gameover < totalHeaps; gameover++){
                    cout<<heaps[gameover]<<" ";
                }
                cout<<endl;
                cout<<"Player computer has won"<< endl;
                return 0;
            }
        } else if (turn == "human") {
            
            // take only valid user input for human turn
            // to take only integer type input
            
            cout<<"Player human enter the number of objects (Y) to take from what heap (X)- in order: Y X"
                << endl;
            int objects = 0;
            int identifier = 0;
            stringstream ss;
            string input = "";
            getline(cin, input);
            if(input.length() != 3){
                cout<< "Player human that is an invalid move, try again"<< endl;
                return 0; // skip to human
            }
            string token1 = input.substr(0, 1);
            ss << input.substr(0, 1);
            ss >> objects;
            ss.flush();
            string token2 = input.substr(2, 3);
            ss << input.substr(2, 3);
            ss >> identifier;
            //ss << input;
            //ss >> objects >> identifier;
            cout    << "Player human took"<< objects <<" "<<token2<<" " 
                    << identifier<<endl; //<< vect<1><< endl;
            return 0;

            validate the integers entered as input
            
            if (identifier < totalHeaps || heaps[identifier] <= 0 || objects > heaps[identifier]){
                cout<< "Invalid Input" << endl;
             }
    
            // Prints the objects drawn by human player and the remaining objects
    
            else {
                 heaps[identifier]-= objects;
                 cout << "Player Human took" << objects << "objects from heap" << identifier << endl;
                    
                    int k=0;
                     for (k=0;k < totalHeaps;k++){
                         cout<<heaps[k]<<" ";
                     }
                         cout<<endl;
                 }
             turn = "computer";
            if(isHeapsEmpty(heaps,totalHeaps)){
                 cout<<"Player human has won"<< endl;
                 return 0;
             }
        }
        for (int lastk=0; lastk < totalHeaps; lastk++){
            cout<<heaps[lastk]<<" ";
        }
        cout<<endl;
    }

}

bool isHeapsEmpty(int heaps[], int size) {
//    int size = sizeof(heaps)/sizeof(heaps[0]);
    int sum = 0;
    for (int i=0; i < size; i++) {
        sum += heaps[i];
    }
    if(sum == 0){
        return true;
    }
    else {
        return false;
    }
}
