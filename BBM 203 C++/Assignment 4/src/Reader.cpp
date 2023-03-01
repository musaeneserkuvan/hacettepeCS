

#include "Reader.h"


Reader::Reader() = default;

void Reader::Read(AVL&  AVLobj,LLRBT& llrbtObj,string& a,string& b,string& c) {

    string inputtext;
    ifstream myReadTxt(a.c_str());

    while (getline (myReadTxt, inputtext)){

        istringstream ss(inputtext);
        string token;

        string inp1;
        string inp2;
        string inp3;

        string inp4;
        int inp5;

        getline(ss, inp1,'\t');

        if (inp1 == "insert"){

            getline(ss, inp2,'\t');
            getline(ss, inp3,'\t');
            getline(ss, inp4,'\n');
            stringstream  s;
            s << inp4;
            s >> inp5;

            AVLobj.insert(inp2,inp3,inp5);

            llrbtObj.insert(inp2,inp3,inp5);

        }
        else if (inp1 == "remove"){

            getline(ss, inp2,'\t');
            getline(ss, inp3,'\n');

            AVLobj.remove(inp2,inp3);

            llrbtObj.remove(inp2,inp3);

        }
        else if (inp1 == "printAllItems"){
            AVLobj.printAllItems();

            llrbtObj.printAllItems();
        }
        else if (inp1 == "printItem"){

            getline(ss, inp2,'\t');
            getline(ss, inp3,'\n');

            AVLobj.printItem(inp2,inp3);

            llrbtObj.printItem(inp2,inp3);

        }
        else if (inp1 == "updateData"){

            getline(ss, inp2,'\t');
            getline(ss, inp3,'\t');
            getline(ss, inp4,'\n');
            stringstream  s;
            s << inp4;
            s >> inp5;

            AVLobj.updateData(inp2,inp3,inp5);

            llrbtObj.updateData(inp2,inp3,inp5);

        }
        else if (inp1 == "printAllItemsInCategory"){

            getline(ss, inp2,'\n');

            AVLobj.printAllItemsInCategory(inp2);

            llrbtObj.printAllItemsInCategory(inp2);

        }
        else if (inp1 == "find"){

            getline(ss, inp2,'\t');
            getline(ss, inp3,'\n');

            AVLobj.find(inp2,inp3);

            llrbtObj.find(inp2,inp3);

        }

    }

    myReadTxt.close();

    ofstream MyOutputTxt1(b.c_str());



    while (AVLobj.headO != nullptr){

        string y;

        y = AVLobj.PopO();

        MyOutputTxt1<<y ;

    }


    MyOutputTxt1.close();

    ofstream MyOutputTxt2(c.c_str());

    while (llrbtObj.headO != nullptr){

        string x;

        x = llrbtObj.PopO();
        MyOutputTxt2<<x ;

    }

    MyOutputTxt2.close();

}

