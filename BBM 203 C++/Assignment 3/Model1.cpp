//
// Created by djene on 11.12.2022.
//

#include "Model1.h"

Model1::Model1() {

    CashierQHeadnode= nullptr;
    CashierQRearnode= nullptr;

    BaristaQHeadnode= nullptr;
    BaristaQRearnode= nullptr;

    CasHeadnode= nullptr;
    CasRearnode= nullptr;

    BarHeadnode= nullptr;
    BarRearnode= nullptr;

}

void Model1::Enqueue(double a, double b, double c, double d) {

    nodeCustomer* newN = new nodeCustomer;
    newN->arrivaltime=a;
    newN->ordertime=b;
    newN->brewtime=c;
    newN->price=d;

    newN->next= nullptr;

    if (CashierQHeadnode == nullptr && CashierQRearnode == nullptr){
        CashierQHeadnode=CashierQRearnode=newN;
        return;
    }
    CashierQRearnode->next=newN;
    CashierQRearnode=newN;

}

// 3cü fonksiyon
void Model1::AddBaristaQ(Model1::nodeCustomer **temp4) {

    if ( ((*temp4)->arrivaltime+(*temp4)->queueCashierTime+(*temp4)->ordertime) <= totalruntime){


        if ( BaristaQHeadnode == nullptr && BaristaQRearnode == nullptr){
            BaristaQHeadnode = BaristaQRearnode = (*temp4);
        }
        else{
            BaristaQRearnode->next=(*temp4);
            BaristaQRearnode=(*temp4);
        }


        //casiyer isworking false yap
        (*temp4)->holdWorker->isWorking=false;

        // casiyeri geri yolla
        (*temp4)->holdWorker= nullptr;

        // customerin durumlarını değiştir
        (*temp4)->isOrdering=false;
        (*temp4)->inQueueBarista=true;



        // customer temp4 nextini cashier q dan cıkar nullptr yap

        if (CashierQHeadnode != (*temp4)){
            nodeCustomer* tempprev = CashierQHeadnode;
            while ( tempprev->next != (*temp4)){
                tempprev=tempprev->next;
            }
            // temp4ün biröncesinin nexti temp4 nextine
            tempprev->next=(*temp4)->next;
            // temp4 nexti nullptr
            (*temp4)->next= nullptr;


        }else{
            CashierQHeadnode=CashierQHeadnode->next;
            (*temp4)->next= nullptr;
        }

        // price sort
        nodeCustomer* tempSort1 = BaristaQHeadnode;
        nodeCustomer* tempSort2 = BaristaQHeadnode;

        while ( tempSort1 != nullptr){
            if (tempSort1->inQueueBarista && !tempSort1->isBrewing){
                break;
            }
            tempSort1=tempSort1->next;
        }

        if(tempSort1->next != nullptr){

            while (tempSort1 != nullptr){
                if ((*temp4)->price > tempSort1->price){

                    // swap

                    nodeCustomer* tempSort3 = new nodeCustomer;

                    tempSort3->arrivaltime=tempSort1->arrivaltime;
                    tempSort3->ordertime=tempSort1->ordertime;
                    tempSort3->brewtime=tempSort1->brewtime;
                    tempSort3->price=tempSort1->price;

                    tempSort3->queueCashierTime=tempSort1->queueCashierTime;
                    tempSort3->queueBaristaTime=tempSort1->queueBaristaTime;

                    tempSort3->inQueueBarista=true;
                    tempSort3->isBrewing=false;

                    //
                    tempSort1->arrivaltime=(*temp4)->arrivaltime;
                    tempSort1->ordertime=(*temp4)->ordertime;
                    tempSort1->brewtime=(*temp4)->brewtime;
                    tempSort1->price=(*temp4)->price;

                    tempSort1->queueCashierTime=(*temp4)->queueCashierTime;
                    tempSort1->queueBaristaTime=(*temp4)->queueBaristaTime;

                    //
                    (*temp4)->arrivaltime=tempSort3->arrivaltime;
                    (*temp4)->ordertime=tempSort3->ordertime;
                    (*temp4)->brewtime=tempSort3->brewtime;
                    (*temp4)->price=tempSort3->price;

                    (*temp4)->queueCashierTime=tempSort3->queueCashierTime;
                    (*temp4)->queueBaristaTime=tempSort3->queueBaristaTime;

                    // swap bitti

                    tempSort1=tempSort1->next;

                }
                else{
                    tempSort1=tempSort1->next;
                }

            }

        }


        // bir kişi varsa nasıl sort edecek ?



    }


}


// 2ci ve 4cü fonksiyon
void Model1::PopWorker(int a,nodeCustomer** temp4) {

    // casierleri customerlara ulaştırma
    if ( a == 1){

        nodeWorker* temp = CasHeadnode;
        while (temp!= nullptr){

            if (!temp->isWorking){

                (*temp4)->holdWorker = temp;
                // busy time casieri ilk getirince verdik burda cıkarırkende verilir mi bak
                (*temp4)->holdWorker->busytime=(*temp4)->ordertime;

                // customer changleri burda ekleyince
                (*temp4)->inQueueCashier=false;
                (*temp4)->isOrdering=true;

                temp->isWorking=true;

                break;
            }
            else{
                temp=temp->nextW;
            }

        }

    }
    // baristaları customerlara ulaştırma
    else{

        nodeWorker* temp = BarHeadnode;
        while (temp!= nullptr){

            if (!temp->isWorking){

                (*temp4)->holdWorker = temp;

                // busy time casieri ilk getirince verdik burda ,cıkarırkende verilir mi bak
                (*temp4)->holdWorker->busytime=(*temp4)->brewtime;

                // customer changleri burda ekleyince
                (*temp4)->inQueueBarista=false;
                (*temp4)->isBrewing=true;

                temp->isWorking=true;

                break;
            }
            else{
                temp=temp->nextW;
            }

        }



    }

}


void Model1::CurrTime() {



    // smallest arriving customer
    double arrvtime{-1};

    nodeCustomer* temp1 = CashierQHeadnode;

    while (temp1!= nullptr){

        if ( !temp1->inQueueCashier && !temp1->isOrdering){
            arrvtime=temp1->arrivaltime;
            break;
        }
        else{
            temp1=temp1->next;
        }
    }




    // jobends smallest cashier
    double jobendsCashier{-1};

    nodeCustomer* temp2 = CashierQHeadnode;
    nodeCustomer* temp3 = CashierQHeadnode;


    while (temp2!= nullptr){

        if (!temp2->inQueueCashier && temp2->isOrdering){

            if (!temp3->inQueueCashier && temp3->isOrdering){

                if ( (temp2->arrivaltime+temp2->queueCashierTime+temp2->ordertime) < (temp3->arrivaltime+temp3->queueCashierTime+temp3->ordertime) ){
                    temp3=temp2;
                    jobendsCashier=temp3->arrivaltime+temp3->queueCashierTime+temp3->ordertime;
                    temp2=temp2->next;

                }
                else{
                    jobendsCashier=temp3->arrivaltime+temp3->queueCashierTime+temp3->ordertime;
                    temp2=temp2->next;

                }

            }
            else{
                temp3=temp2;
                jobendsCashier=temp3->arrivaltime+temp3->queueCashierTime+temp3->ordertime;
                temp2=temp2->next;
            }
        }
        else{
            temp2=temp2->next;
        }
    }




    // jobends smallest barista
    double jobendBarista{-1};

    nodeCustomer* temp4 = BaristaQHeadnode;
    nodeCustomer* temp5 = BaristaQRearnode;

    if (BaristaQHeadnode != nullptr && BaristaQHeadnode == BaristaQRearnode){
        jobendBarista=temp5->arrivaltime+temp5->queueCashierTime+temp5->ordertime+temp5->queueBaristaTime+temp5->brewtime;

    }
    else{
        while (temp4!= nullptr){
            if (!temp4->inQueueBarista && temp4->isBrewing){

                if (!temp5->inQueueBarista && temp5->isBrewing){
                    if ( (temp4->arrivaltime+temp4->queueCashierTime+temp4->ordertime+temp4->queueBaristaTime+temp4->brewtime) < (temp5->arrivaltime+temp5->queueCashierTime+temp5->ordertime+temp5->queueBaristaTime+temp5->brewtime) ){
                        temp5=temp4;
                        jobendBarista=temp5->arrivaltime+temp5->queueCashierTime+temp5->ordertime+temp5->queueBaristaTime+temp5->brewtime;
                        temp4=temp4->next;
                    }
                    else{
                        jobendBarista=temp5->arrivaltime+temp5->queueCashierTime+temp5->ordertime+temp5->queueBaristaTime+temp5->brewtime;
                        temp4=temp4->next;
                    }
                }
                else{
                    temp5=temp4;
                    jobendBarista=temp5->arrivaltime+temp5->queueCashierTime+temp5->ordertime+temp5->queueBaristaTime+temp5->brewtime;
                    temp4=temp4->next;
                }
            }
            else{
                temp4=temp4->next;
            }
        }
    }








    // compare times
    if (arrvtime == -1){

        if (jobendsCashier == -1){
            if (jobendBarista == -1){
                // hiçbir şey
            }
            else{
                totalruntime=jobendBarista;
            }

        }
        else{
            if (jobendBarista == -1){
                totalruntime=jobendsCashier;
            }
            else{
                if (jobendsCashier<jobendBarista){
                    totalruntime=jobendsCashier;
                }
                else{
                    totalruntime=jobendBarista;
                }
            }

        }

    }
    else{

        if (jobendsCashier == -1){
            if (jobendBarista == -1){
                totalruntime=arrvtime;
            }
            else{
                if (arrvtime<jobendBarista){
                    totalruntime=arrvtime;
                }
                else{
                    totalruntime=jobendBarista;
                }
            }

        }
        else{
            if (jobendBarista == -1){
                if (arrvtime<jobendsCashier){
                    totalruntime=arrvtime;
                }
                else{
                    totalruntime=jobendsCashier;
                }
            }
            else{

                if(arrvtime <= jobendsCashier && arrvtime <= jobendBarista)
                    totalruntime=arrvtime;
                else if(jobendsCashier <= arrvtime && jobendsCashier <= jobendBarista)
                    totalruntime=jobendsCashier;
                else
                    totalruntime=jobendBarista;
            }

        }

    }




}

void Model1::CheckQueue() {



    // 1ci fonksiyon
    // 1 aktive et yeni müşteri cashier q ekle
    nodeCustomer* temp5 = CashierQHeadnode;
    while (temp5!= nullptr){

        if (!temp5->inQueueCashier && !temp5->isOrdering){

            if ( totalruntime >= temp5->arrivaltime){


                temp5->inQueueCashier=true;
                break;

            }

        }
        temp5=temp5->next;
    }


    // 5ci fonksiyon
    // 5 biten var mı
    nodeCustomer* temp1 = BaristaQHeadnode;
    while (temp1!= nullptr){


        if ( !temp1->inQueueBarista && temp1->isBrewing){

            if ( totalruntime >= (temp1->arrivaltime+temp1->queueCashierTime+temp1->ordertime+temp1->queueBaristaTime+temp1->brewtime)){

                // biten customer değerleri
                temp1->isBrewing=false;

                // baristayı bırakıyor
                temp1->holdWorker->isWorking= false;
                temp1->holdWorker= nullptr;

                // served ekliyor
                servedN++;

            }
        }
        temp1=temp1-> next;

    }


    // 3 boşalt ve aktive et cashier biten var mı
    nodeCustomer* temp3 = CashierQHeadnode;
    while (temp3!= nullptr){

        if ( !temp3->inQueueCashier && temp3->isOrdering){
            // biteni ekle

            AddBaristaQ(&temp3);

        }
        temp3=temp3->next;
    }


    // 4 barista queue da bekleyen var mı
    nodeCustomer* temp2 = BaristaQHeadnode;
    while (temp2!= nullptr){
        if (temp2->inQueueBarista && !temp2->isBrewing){

            temp2->queueBaristaTime = totalruntime - ( temp2->arrivaltime+temp2->queueCashierTime+temp2->ordertime);
            // boşta varsa geçir

            PopWorker(0,&temp2);

        }
        temp2=temp2-> next;
    }



    // 2 cashier queue da bekleyen var mı
    nodeCustomer* temp4 = CashierQHeadnode;
    while (temp4!= nullptr){

        if ( temp4->inQueueCashier && !temp4->isOrdering){



            temp4->queueCashierTime= totalruntime - (temp4->arrivaltime) ;


            //  geçir
            // if size ile bakıyordum gerek kalmadı popta null sa birşey yapmıyor
            PopWorker(1,&temp4);

        }
        temp4=temp4->next;
    }




}

void Model1::AddWorker(int a) {

    if (a ==1){

        nodeWorker* cas = new nodeWorker;
        cas->nextW= nullptr;

        if (CasHeadnode == nullptr && CasRearnode == nullptr){

            CasHeadnode=CasRearnode=cas;
            return;
        }
        CasRearnode->nextW=cas;
        CasRearnode=cas;

    }
    else{

        nodeWorker* bar = new nodeWorker;
        bar->nextW=new nodeWorker;

        if (BarHeadnode == nullptr && BarRearnode == nullptr){

            BarHeadnode=BarRearnode=bar;
            return;
        }
        BarRearnode->nextW=bar;
        BarRearnode=bar;

    }


}

void Model1::print() {

    cout<<totalruntime<<endl;

    cout<<endl;
    cout<<endl;

    nodeWorker* cas = CasHeadnode;
    while (cas != nullptr){
        cout<<(cas->busytime) / totalruntime<<endl;
        cas=cas->nextW;
    }

    nodeWorker* bar = BarHeadnode;
    while (bar != nullptr){
        cout<<(bar->busytime) / totalruntime<<endl;
        bar=bar->nextW;
    }

    nodeCustomer* cus = BaristaQHeadnode;

    while (cus != nullptr){
        cout<< cus->queueCashierTime+cus->ordertime+cus->queueBaristaTime+cus->brewtime<<endl;
        cus=cus->next;
    }





}







