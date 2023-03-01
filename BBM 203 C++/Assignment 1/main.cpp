#include "Machine.h"

using namespace std;

int main(int argc,char* argv[]) {

    Machine OBJECT ;

    OBJECT.MapDim(argv[1],OBJECT,argv[2],argv[3],argv[4],argv[5]);

    OBJECT.DefMatrix(OBJECT);

    OBJECT.ReaderFunc(OBJECT);

    OBJECT.StartDefine(OBJECT);

    OBJECT.setOutputString(OBJECT.Multiplier(OBJECT));

    OBJECT.Write(OBJECT);

    OBJECT.FreeAlloc(OBJECT);



    return 0;

}


