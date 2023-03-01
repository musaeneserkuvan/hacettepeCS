

#ifndef UNTITLED19_AVL_H
#define UNTITLED19_AVL_H


#include <iostream>

using namespace std;
class AVL {

public:
    struct secondaryN{

        string keyItem;

        secondaryN* rightsecondaryN;
        secondaryN* leftsecondaryN;

        int data;

    };

    struct primaryN{

        string keyCategory;

        primaryN* rightprimaryN;
        primaryN* leftprimaryN;

        secondaryN* rootsecondaryN;

    };

    struct queuePrimary{

        primaryN* hold;
        queuePrimary* next;
    };

    struct queueSecondary{

        secondaryN* hold;
        queueSecondary* next;
    };

    struct Output{

        Output* next;
        string s;
    };

    Output* headO;
    Output* rearO;

    queueSecondary* headSecondaryQ;
    queueSecondary* rearSecondaryQ;

    queuePrimary* headPrimaryQ;
    queuePrimary* rearPrimaryQ;

    primaryN* rootprimaryN;



    //-------CONSTRUCTOR-------//
    AVL();
    //-------------------------------------------------------------------------------------


    void EnqueuePrimary(primaryN** ptr);
    void DequeuePrimary();

    void EnqueueSecondary(secondaryN** ptr);
    void DequeueSecondary();

    void PushO(string s);
    string PopO();


    //-------FUNCTION 1 INSERT-------//
    // we use this functions to add nodes to BST tree and subtrees
    void insert(const string& category,const string& itemname,int price);

    void addNodePrimary(const string& category,const string& itemname, int price,primaryN** ptr);
    void addNodeSecondary(const string& itemname,int price,secondaryN** ptr);
    //-------------------------------------------------------------------------------------

    //-------FUNCTION 2 RETRIEVING THE SEARCH ITEM-------//
    // we use retrieveNode function and this function calls retrieve with parameter rootprimaryN
    primaryN* SearchPrimaryTree(const string& category);
    secondaryN* SearchSecondaryTree(const string& itemname,secondaryN** ptr);
    // we use function to return primary node matched with the argument category
    primaryN* retrievePrimaryNode(const string& category,primaryN** ptr);
    //-------------------------------------------------------------------------------------

    //-------FUNCTION 3 CREATING NODES-------//
    static primaryN* createPrimaryNode(string category);
    static secondaryN* createSecondaryNode(string itemname,int price);
    //-------------------------------------------------------------------------------------

    //-------FUNCTION 4 PRINT-------//
    void printAllItems();
    void printAllItemsLevelOrder(primaryN** ptr);
    void print(secondaryN** ptr);
    void printAllItemsInCategory(const string& category);
    void printItem(const string& category,const string& itemname);
    void find(const string& category,const string& itemname);
    //-------------------------------------------------------------------------------------

    //-------FUNCTION 5 HEIGHT OF TREE-------//
    int height(secondaryN** ptr);

    //-------FUNCTION 6 ROTATE-------//

    static void rotateRight(secondaryN** ptr);
    static void rotateLeft(secondaryN** ptr);
    void remove(const string& category,const string& itemname);
    void removePrimary(const string& category,const string& itemname,primaryN** ptr);
    void removeNode(const string& category,const string& itemname,secondaryN** ptr);
    void updateData(const string& category,const string& itemname,int newPrice);


    secondaryN** minValSecondNode(secondaryN** ptr);


};


#endif //UNTITLED19_AVL_H
