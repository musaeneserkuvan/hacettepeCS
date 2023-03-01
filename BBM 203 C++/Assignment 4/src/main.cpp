
#include "AVL.h"
#include "LLRBT.h"
#include "Reader.h"

int main(int argc, char *argv[]) {

    string a = argv[1];
    string b = argv[2];
    string c = argv[3];

    AVL part1 = AVL();

    LLRBT part2 = LLRBT();

    Reader::Read(part1,part2,a,b,c);



    return 0;
}
