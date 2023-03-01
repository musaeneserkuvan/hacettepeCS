
#ifndef UNTITLED12_MODEL1_H
#define UNTITLED12_MODEL1_H
#include <iostream>

using namespace std;
class Model1 {

public:

    double totalruntime{-1};

    int numberOrder{};

    int servedN{0};

    struct nodeWorker{

        bool isWorking{false};

        double busytime{0};

        nodeWorker* nextW;

    };

    struct nodeCustomer{

        double arrivaltime{};
        double ordertime{};
        double brewtime{};
        double price{};

        double queueCashierTime{};
        double queueBaristaTime{};

        bool inQueueCashier{false};
        bool inQueueBarista{false};

        bool isOrdering{false};
        bool isBrewing{false};

        nodeCustomer* next;

        nodeWorker* holdWorker;

    };


    nodeCustomer* CashierQHeadnode;
    nodeCustomer* CashierQRearnode;

    nodeCustomer* BaristaQHeadnode;
    nodeCustomer* BaristaQRearnode;

    nodeWorker* BarHeadnode;
    nodeWorker* BarRearnode;

    nodeWorker* CasHeadnode;
    nodeWorker* CasRearnode;

    Model1();

    void PopWorker(int a,nodeCustomer** temp4);
    void AddBaristaQ(nodeCustomer** temp4);
    void Enqueue(double a,double b, double c , double d);
    void CurrTime();
    void CheckQueue();
    void AddWorker(int a);

    void print();

};


#endif //UNTITLED12_MODEL1_H
