#include <iostream>
#include "Model1.h"
#include "Reader.h"

using namespace std;

int main() {


    Model1 Queue1 = Model1();

    Reader* readerObj = new Reader();

    readerObj->Read(Queue1);

    while (Queue1.servedN<Queue1.numberOrder){

        Queue1.CurrTime();
        cout<<Queue1.totalruntime<<endl;

        Queue1.CheckQueue();


    }
   // Queue1.print();


    return 0;
}
