

#ifndef UNTITLED19_READER_H
#define UNTITLED19_READER_H


#include <fstream>
#include <sstream>
#include "AVL.h"
#include "LLRBT.h"



using namespace std;
class Reader {

public:

    Reader();

    static void Read(AVL&  AVLobj,LLRBT& llrbtObj,string& a, string& b,string& c);



};



#endif //UNTITLED19_READER_H
