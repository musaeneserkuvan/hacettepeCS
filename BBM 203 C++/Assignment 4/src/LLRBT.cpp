
#include "LLRBT.h"

#include <sstream>
#include <utility>

LLRBT::LLRBT() {

    rootprimaryN = nullptr;

    headSecondaryQ= nullptr;
    rearSecondaryQ= nullptr;

    headPrimaryQ= nullptr;
    rearPrimaryQ= nullptr;

    headO= nullptr;
    rearO= nullptr;

}

void LLRBT::insert(const string& category,const string& itemname, int price) {

    addNodePrimary(category,itemname,price,&rootprimaryN);

    // balance primary

}

void LLRBT::addNodePrimary(const string& category,const string& itemname, int price,primaryN** ptr) {

    // if TPLLRBT is empty
    if ( (*ptr) == nullptr){

        // define root node of primary tree
        (*ptr) = createPrimaryNode(category);
        // connect primary and second node

        addNodeSecondary( itemname,price, &(*ptr)->rootsecondaryN,&(*ptr)->rootsecondaryN);
        // balance secondary

    }
    else if( category == (*ptr)->keyCategory){
        // insert secondary node to secondary tree and balance
        addNodeSecondary( itemname,price, &(*ptr)->rootsecondaryN,&(*ptr)->rootsecondaryN);

        // balance secondary , &(*ptr)->rootsecondaryN = addNodeSecondary( itemname,price, &(*ptr)->rootsecondaryN);

    }
    else if ( category < (*ptr)->keyCategory){
        addNodePrimary(category,itemname,price,&(*ptr)->leftprimaryN);
    }
    else if ( category > (*ptr)->keyCategory){
        addNodePrimary(category,itemname,price,&(*ptr)->rightprimaryN);
    }

}


void LLRBT::addNodeSecondary(const string& itemname,int price, LLRBT::secondaryN** ptr,LLRBT::secondaryN** root) {

    // bu ptrye eklenecek

    if ((*ptr) == nullptr){

        (*ptr) = createSecondaryNode(itemname,price);

        if ((*ptr) == (*root) ){
            (*ptr)->color=false;

        }

    }
        // sola eklenecek
    else if ( itemname < (*ptr)->keyItem ){
        addNodeSecondary( itemname,price, &(*ptr)->leftsecondaryN ,&(*root));}
        // sağa eklenecek
    else if (itemname > (*ptr)->keyItem){

        addNodeSecondary( itemname,price, &(*ptr)->rightsecondaryN,&(*root));}

    // eşitse ekleme yapmıyoruz belki update yaparız burda böyle bir input yok

    // balance


    if ((*ptr)->rightsecondaryN != nullptr){

        if ( (*ptr)->rightsecondaryN->color ){

            if ((*ptr)->leftsecondaryN== nullptr){
                rotateLeft(&(*ptr));

                bool temp =(*ptr)->color;
                (*ptr)->color=(*ptr)->leftsecondaryN->color;
                (*ptr)->leftsecondaryN->color=temp;

                if ((*ptr) == (*root) ){
                    (*ptr)->color=false;
                }
            }
            if ( !(*ptr)->leftsecondaryN->color ){
                rotateLeft(&(*ptr));

                bool temp =(*ptr)->color;
                (*ptr)->color=(*ptr)->leftsecondaryN->color;
                (*ptr)->leftsecondaryN->color=temp;

                if ((*ptr) == (*root) ){
                    (*ptr)->color=false;
                }

            }

        }
    }

    if ((*ptr)->leftsecondaryN != nullptr && (*ptr)->leftsecondaryN->leftsecondaryN != nullptr ){

        if ((*ptr)->leftsecondaryN->color  &&
            (*ptr)->leftsecondaryN->leftsecondaryN->color ){

            rotateRight(&(*ptr));

            bool temp =(*ptr)->color;



            if ((*ptr)->rightsecondaryN != nullptr){
                (*ptr)->color=(*ptr)->rightsecondaryN->color;
                (*ptr)->rightsecondaryN->color=temp;
            }
            if ((*ptr)->rightsecondaryN == nullptr){
                (*ptr)->color=false;
            }

            if ((*ptr) == (*root) ){
                (*ptr)->color=false;
            }



        }
    }

    if ((*ptr)->leftsecondaryN != nullptr && (*ptr)->rightsecondaryN != nullptr){


        if ((*ptr)->leftsecondaryN->color &&
            (*ptr)->rightsecondaryN->color){

            (*ptr)->color = !(*ptr)->color;
            (*ptr)->leftsecondaryN->color = !(*ptr)->leftsecondaryN->color;
            (*ptr)->rightsecondaryN->color = !(*ptr)->rightsecondaryN->color;

            if ((*ptr) == (*root) ){
                (*ptr)->color=false;
            }

        }


    }

}

LLRBT::primaryN *LLRBT::createPrimaryNode(string category) {

    // create primary node
    auto* nodenew = new primaryN;

    nodenew->rightprimaryN= nullptr;
    nodenew->leftprimaryN= nullptr;

    nodenew->keyCategory = std::move(category);

    nodenew->rootsecondaryN= nullptr;

    return nodenew;
}

LLRBT::secondaryN *LLRBT::createSecondaryNode(string itemname, int price) {

    // create secondary node
    auto* nodenew2 = new secondaryN;

    nodenew2->rightsecondaryN= nullptr;
    nodenew2->leftsecondaryN= nullptr;

    nodenew2->keyItem=std::move(itemname);
    nodenew2->data=price;
    nodenew2->color= true;

    return nodenew2;
}


void LLRBT::printAllItems() {

    printAllItemsLevelOrder(&rootprimaryN);


}

void LLRBT::printAllItemsLevelOrder(LLRBT::primaryN** ptr) {

    PushO("command:printAllItems""\n");


    // if tree is NOT empty
    if ((*ptr) != nullptr){


        PushO("{""\n");

        EnqueuePrimary(&(*ptr));

        while ( headPrimaryQ != nullptr){

            if (headPrimaryQ->hold->rootsecondaryN == nullptr){

                PushO("\""+headPrimaryQ->hold->keyCategory+"\""+":");

                PushO("{}""\n");
            }
            else{

                PushO("\""+headPrimaryQ->hold->keyCategory+"\""+":""\n");
                print( & (headPrimaryQ->hold->rootsecondaryN) );
            }

            if (headPrimaryQ->hold->leftprimaryN != nullptr){
                EnqueuePrimary( & (headPrimaryQ->hold->leftprimaryN));
            }
            if (headPrimaryQ->hold->rightprimaryN != nullptr){
                EnqueuePrimary( & (headPrimaryQ->hold->rightprimaryN) );
            }

            DequeuePrimary();

        }


        PushO("}""\n");
    }
        // if tree is empty
    else{

        PushO("{}""\n");
    }

}

void LLRBT::print(LLRBT::secondaryN** ptr) {


    EnqueueSecondary(&(*ptr));

    while ( headSecondaryQ != nullptr){

        // print queue first node
        queueSecondary* temp = headSecondaryQ;

        while (temp != nullptr){

            if ( temp == headSecondaryQ && temp == rearSecondaryQ){



                stringstream dat;
                dat<<temp->hold->data;
                string dati;
                dat>>dati;

                PushO("\t""\""+temp->hold->keyItem+"\""+":"+"\""+dati+"\"""\n");
            }
            else if(temp == headSecondaryQ && temp != rearSecondaryQ){


                stringstream dat;
                dat<<temp->hold->data;
                string dati;
                dat>>dati;

                PushO("        ""\""+temp->hold->keyItem+"\""+":"+"\""+dati+"\""+",");

            }
            else if (temp != headSecondaryQ && temp != rearSecondaryQ){


                stringstream dat;
                dat<<temp->hold->data;
                string dati;
                dat>>dati;

                PushO("\""+temp->hold->keyItem+"\""+":"+"\""+dati+"\""+",");

            }
            else if (temp != headSecondaryQ && temp == rearSecondaryQ){


                stringstream dat;
                dat<<temp->hold->data;
                string dati;
                dat>>dati;

                PushO("\""+temp->hold->keyItem+"\""+":"+"\""+dati+"\"""\n");

            }
            temp=temp->next;
        }

        queueSecondary* temp2 = headSecondaryQ;
        queueSecondary* temp3 = rearSecondaryQ;


        while (temp2 != nullptr){

            // first node nin solu sagı
            if ( temp2->hold->leftsecondaryN != nullptr){
                EnqueueSecondary(&temp2->hold->leftsecondaryN);
            }
            if ( temp2->hold->rightsecondaryN != nullptr ){
                EnqueueSecondary(&temp2->hold->rightsecondaryN);
            }

            if ( temp2 == temp3){
                // pop first node
                DequeueSecondary();
                temp2= nullptr;
            }
            else{
                temp2=temp2->next;
                //pop first node
                DequeueSecondary();

            }

        }
    }
}

void LLRBT::EnqueueSecondary(secondaryN** ptr) {

    auto* newQ= new queueSecondary;

    newQ->next= nullptr;
    newQ->hold=(*ptr);

    if ( headSecondaryQ == nullptr && rearSecondaryQ == nullptr){
        headSecondaryQ=rearSecondaryQ=newQ;
    }
    else{
        rearSecondaryQ->next=newQ;
        rearSecondaryQ=newQ;
    }

}

void LLRBT::EnqueuePrimary(primaryN** ptr) {

    auto* newQ= new queuePrimary;

    newQ->next= nullptr;
    newQ->hold=(*ptr);

    if ( headPrimaryQ == nullptr && rearPrimaryQ == nullptr){
        headPrimaryQ=rearPrimaryQ=newQ;
    }
    else{
        rearPrimaryQ->next=newQ;
        rearPrimaryQ=newQ;
    }
}

void LLRBT::DequeueSecondary() {

    queueSecondary* newQ= headSecondaryQ;

    if ( headSecondaryQ == nullptr){
        return;
    }
    if ( headSecondaryQ == rearSecondaryQ){
        headSecondaryQ= nullptr;
        rearSecondaryQ= nullptr;
    }
    else{
        headSecondaryQ=headSecondaryQ->next;
    }

    newQ->next= nullptr;
    newQ->hold= nullptr;
    free(newQ);

}

void LLRBT::DequeuePrimary() {

    queuePrimary* newQ= headPrimaryQ;

    if ( headPrimaryQ == rearPrimaryQ){

        headPrimaryQ= nullptr;
        rearPrimaryQ= nullptr;
    }
    else{
        headPrimaryQ=headPrimaryQ->next;
    }

    newQ->next= nullptr;

    newQ->hold= nullptr;

    free(newQ);

}

int LLRBT::height(secondaryN** ptr) {

    if ( (*ptr) == nullptr){
        return 0;
    }

    int a = height( &(*ptr)->leftsecondaryN);
    int b = height( &(*ptr)->rightsecondaryN);

    int c =a>b? a:b;

    return 1+ c;

}

void LLRBT::rotateRight(LLRBT::secondaryN **ptr) {

    secondaryN* x = (*ptr)->leftsecondaryN;
    secondaryN* xright = x->rightsecondaryN;

    x->rightsecondaryN = (*ptr);
    (*ptr)->leftsecondaryN = xright;

    (*ptr) = x;

}

void LLRBT::rotateLeft(LLRBT::secondaryN **ptr) {

    secondaryN* x = (*ptr)->rightsecondaryN;
    secondaryN* xleft=x->leftsecondaryN;

    x->leftsecondaryN = (*ptr);
    (*ptr)->rightsecondaryN=xleft;

    (*ptr)=x;

}

void LLRBT::printAllItemsInCategory(const string& category) {


    PushO("command:printAllItemsInCategory        "+category+"\n");

    if ( SearchPrimaryTree(category) != nullptr){

        PushO("{""\n");
        if (SearchPrimaryTree(category)->rootsecondaryN != nullptr){



            PushO("\""+SearchPrimaryTree(category)->keyCategory+"\""+":""\n");


            print(&(SearchPrimaryTree(category)->rootsecondaryN));

        }
        else{

            PushO("\""+SearchPrimaryTree(category)->keyCategory+"\""+":"+"{}""\n");
        }

        PushO("}""\n");
    }
    else{

        PushO("{}""\n");
    }

}

void LLRBT::printItem(const string& category, const string& itemname) {


    PushO("command:printItem        "+category+"        "+itemname+"\n");

    if ( SearchPrimaryTree(category) != nullptr){

        if (SearchSecondaryTree(itemname, & SearchPrimaryTree(category)->rootsecondaryN) != nullptr){

            PushO("{""\n");

            PushO("\""+SearchPrimaryTree(category)->keyCategory+"\""+":""\n");


            stringstream dat;
            dat<<SearchSecondaryTree(itemname,& SearchPrimaryTree(category)->rootsecondaryN)->data;
            string dati;
            dat>>dati;

            PushO("        ""\""+SearchSecondaryTree(itemname,& SearchPrimaryTree(category)->rootsecondaryN)->keyItem+"\""+":"+"\""+dati+"\"""\n");


            PushO("}""\n");
        }
        else{
            PushO("{}""\n");
        }
    }
    else{
        PushO("{}""\n");
    }

}

LLRBT::primaryN *LLRBT::SearchPrimaryTree(const string& category) {
    return retrievePrimaryNode(category,&rootprimaryN);
}

LLRBT::primaryN *LLRBT::retrievePrimaryNode(const string& category, LLRBT::primaryN** ptr) {

    // ptr is NOT empty
    if ( (*ptr) != nullptr){
        // key value is same with node value
        if ( (*ptr)->keyCategory == category){
            return (*ptr);
        }
            // key value is NOT same with node value
        else{
            // if key value is lexicographically lesser than ptr
            if ( category < (*ptr)->keyCategory){
                return retrievePrimaryNode(category,&(*ptr)->leftprimaryN);
            }
                // if key value is lexicographically greater than ptr
            else{
                return retrievePrimaryNode(category,&(*ptr)->rightprimaryN);
            }
        }
    }
        // ptr is empty
    else{
        return nullptr;
    }

}

LLRBT::secondaryN *LLRBT::SearchSecondaryTree(const string& itemname,secondaryN** ptr) {

    if ( (*ptr) != nullptr){

        if ( (*ptr)->keyItem == itemname){
            return (*ptr);
        }
            // key value is NOT same with node value
        else{
            // if key value is lexicographically lesser than ptr
            if ( itemname < (*ptr)->keyItem){
                return SearchSecondaryTree(itemname,&(*ptr)->leftsecondaryN);
            }
                // if key value is lexicographically greater than ptr
            else{
                return SearchSecondaryTree(itemname,&(*ptr)->rightsecondaryN);
            }

        }

    }
    else{
        return nullptr;
    }

}

void LLRBT::find(const string& category, const string& itemname) {

    PushO("command:find        "+category+"        "+itemname+"\n");

    if ( SearchPrimaryTree(category) != nullptr){

        if (SearchSecondaryTree(itemname, & SearchPrimaryTree(category)->rootsecondaryN) != nullptr){
            PushO("{""\n");

            PushO("\""+SearchPrimaryTree(category)->keyCategory+"\""+":""\n");

            stringstream dat;
            dat<<SearchSecondaryTree(itemname,& SearchPrimaryTree(category)->rootsecondaryN)->data;
            string dati;
            dat>>dati;
            PushO("        ""\""+SearchSecondaryTree(itemname,& SearchPrimaryTree(category)->rootsecondaryN)->keyItem+"\""+":"+"\""+dati+"\"""\n");

            PushO("}""\n");
        }
        else{
            PushO("{}""\n");
        }
    }
    else{
        PushO("{}""\n");

    }

}

void LLRBT::updateData(const string& category, const string& itemname, int newPrice) {

    if ( SearchPrimaryTree(category) != nullptr){
        if (SearchSecondaryTree(itemname, & SearchPrimaryTree(category)->rootsecondaryN) != nullptr){
            SearchSecondaryTree(itemname,& SearchPrimaryTree(category)->rootsecondaryN)->data=newPrice;
        }
    }

}

void LLRBT::remove(const string& category, const string& itemname) {

    removePrimary(category,itemname,&rootprimaryN);

}

void LLRBT::removePrimary(const string& category, const string& itemname, LLRBT::primaryN** ptr) {

    if ( (*ptr) != nullptr){

        if ( category == (*ptr) ->keyCategory ){
            removeNode(category,itemname,&(*ptr)->rootsecondaryN,&(*ptr)->rootsecondaryN);

            if ((*ptr)->rootsecondaryN != nullptr){
                (*ptr)->rootsecondaryN->color=false;
            }
        }
        else if ( category < (*ptr) ->keyCategory){
            removePrimary(category,itemname,&(*ptr)->leftprimaryN);
        }
        else if (category > (*ptr) ->keyCategory){
            removePrimary(category,itemname,&(*ptr)->rightprimaryN);
        }
    }
    else{
        return;
    }

}

LLRBT::secondaryN** LLRBT::minValSecondNode(secondaryN** ptr) {


    if ( (*ptr) == nullptr){
        return nullptr;
    }

    if ((*ptr)->leftsecondaryN == nullptr){
        return &(*ptr);
    }
    else{
        return minValSecondNode( &(*ptr)->leftsecondaryN );
    }

}

void LLRBT::removeNode(const string& category, const string& itemname, LLRBT::secondaryN** ptr,LLRBT::secondaryN** root) {


    if (itemname < (*ptr)->keyItem){


        if (  !isRed(&(*ptr)->leftsecondaryN) && !isRed(&(*ptr)->leftsecondaryN->leftsecondaryN)){

            (*ptr)->color=false;
            (*ptr)->leftsecondaryN->color=true;

            if(isRed(&(*ptr)->rightsecondaryN->leftsecondaryN)){
                rotateRight(&(*ptr)->rightsecondaryN);
                rotateLeft(&(*ptr));
            }
            else{
                (*ptr)->rightsecondaryN->color=true;
            }

        }
        removeNode(category,itemname,&(*ptr)->leftsecondaryN,root);
    }
    else{

        if (isRed(&(*ptr)->leftsecondaryN)){

            rotateRight(&(*ptr));

            bool temp = (*ptr)->color;
            (*ptr)->color = (*ptr)->rightsecondaryN->color;
            (*ptr)->rightsecondaryN->color = temp;

        }
        if ( itemname == (*ptr)->keyItem && (*ptr)->rightsecondaryN == nullptr){
            secondaryN* temp = (*ptr);
            (*ptr)= nullptr;
            free(temp);
            return ;
        }
        if ( !isRed(&(*ptr)->rightsecondaryN) && !isRed(&(*ptr)->rightsecondaryN->leftsecondaryN)){


            (*ptr)->color=false;
            (*ptr)->rightsecondaryN->color=true;

            if (isRed(&(*ptr)->leftsecondaryN->leftsecondaryN)){
                rotateRight(&(*ptr));
            }
            (*ptr)->color=true;
            (*ptr)->leftsecondaryN->color=false;

        }
        if(itemname == (*ptr)->keyItem){

            secondaryN* temp = (*ptr);

            (*ptr)= (*minValSecondNode( &(*ptr)->rightsecondaryN));

            (*ptr)->leftsecondaryN= temp->leftsecondaryN;

            if (temp->rightsecondaryN != (*ptr)){
                (*ptr)->rightsecondaryN= temp->rightsecondaryN;
            }

            *minValSecondNode( &(*ptr)->rightsecondaryN) = nullptr;

            temp->rightsecondaryN= nullptr;
            temp->leftsecondaryN= nullptr;
            free(temp);


        }
        else{
            removeNode(category,itemname,&(*ptr)->rightsecondaryN,root);

        }
    }
    if (isRed(&(*ptr)->rightsecondaryN)){


        rotateLeft(&(*ptr));

        bool temp = (*ptr)->color;
        (*ptr)->color = (*ptr)->leftsecondaryN->color;
        (*ptr)->leftsecondaryN->color = temp;

    }

}





bool LLRBT::isRed(LLRBT::secondaryN **ptr) {

    if ((*ptr) == nullptr) return false;
    return (*ptr)->color;
}

void LLRBT::PushO(string s) {

    auto* newQ= new Output;

    newQ->next= nullptr;
    newQ->s=std::move(s);

    if ( headO == nullptr && rearO == nullptr){
        headO=rearO=newQ;
    }
    else{
        rearO->next=newQ;
        rearO=newQ;
    }


}

string LLRBT::PopO() {

    Output* newQ= headO;

    if ( headO == rearO){

        headO= nullptr;
        rearO= nullptr;

    }
    else{
        headO=headO->next;
    }

    string a = newQ->s;

    newQ->next= nullptr;

    free(newQ);

    return a;
}

