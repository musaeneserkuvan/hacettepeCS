//
// Created by djene on 11.12.2022.
//

#include "Reader.h"

Reader::Reader() {

}

void Reader::Read(Model1 &object) {

    string inputtext;
    ifstream myReadTxt("D:\\input.txt");

    int reading=0;

    while (getline (myReadTxt, inputtext)) {

        reading++;

        if ( reading ==1){

            int a;
            stringstream int1{};
            int1 << inputtext;
            int1 >> a;


            // create cashier nodes
            for (int i = 0; i < a; ++i) {
                object.AddWorker(1);
            }

            // create barista nodes
            for (int i = 0; i < (a)/3; ++i) {
                object.AddWorker(0);
            }

        }

        else if ( reading == 2){

            stringstream int1;
            int num1;
            int1 << inputtext;
            int1 >> num1;

            object.numberOrder=num1;

        }

        else if ( reading > 2){

            istringstream ss(inputtext);
            string token;

            int line =0;

            double arrival;
            double ordertime;
            double brewtime;
            double priceorde;

            while(getline(ss, token, ' ')) {

                if ( line == 0){ // arrival time
                    stringstream int1;
                    int1 << token;
                    int1 >> arrival;
                    line++;
                }
                else if(line == 1){
                    stringstream int1;
                    int1 << token;
                    int1 >> ordertime;
                    line++;
                }
                else if(line == 2){
                    stringstream int1;
                    int1 << token;
                    int1 >> brewtime;
                    line++;
                }
                else if(line == 3){
                    stringstream int1;
                    int1 << token;
                    int1 >> priceorde;
                    line=0;
                }
            }

            object.Enqueue(arrival,ordertime,brewtime,priceorde);

        }

    }

    myReadTxt.close();

}

