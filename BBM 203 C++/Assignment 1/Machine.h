#include <iostream>

#ifndef UNTITLED1_MACHINE_H
#define UNTITLED1_MACHINE_H

using namespace std;

class Machine {
public:

    Machine();

    // attributes
    int MapRow;
    int MapCol;
    int KeySize;

    string MapTXT;
    string KeyTXT;
    string OutTXT;

    int CurRow;
    int CurCol;

    string OutputString;

    int** KeyM;
    int** MapM;

    // functions
    void MapDim(const char* argDim,Machine &obj,const char* argDim2,const char* argDim3,const char* argDim4,const char* argDim5);

    void DefMatrix(Machine &obj);

    void ReaderFunc(Machine &obj);

    void StartDefine(Machine &obj);

    string Multiplier(Machine &obj);

    void Write(Machine &obj);

    void FreeAlloc(Machine &obj);



    // GETTER AND SETTERS
    int **getKeyM() const;

    int **getMapM() const;

    void setKeyM(int **keyM);

    void setMapM(int **mapM);

    const string &getMapTxt() const;

    void setMapTxt(const string &mapTxt);

    const string &getKeyTxt() const;

    void setKeyTxt(const string &keyTxt);

    const string &getOutTxt() const;

    void setOutTxt(const string &outTxt);

    int getKeySize() const;

    void setKeySize(int keySize);

    int getMapRow() const;

    void setMapRow(int mapRow);

    int getMapCol() const;

    void setMapCol(int mapCol);

    int getCurRow() const;

    void setCurRow(int curRow);

    int getCurCol() const;

    void setCurCol(int curCol);

    const string &getOutputString() const;

    void setOutputString(const string &outputString);

};


#endif //UNTITLED1_MACHINE_H
