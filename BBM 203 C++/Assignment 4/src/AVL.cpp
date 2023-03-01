
#include "AVL.h"

#include <sstream>




AVL::AVL() {

    rootprimaryN = nullptr;

    headSecondaryQ= nullptr;
    rearSecondaryQ= nullptr;

    headPrimaryQ= nullptr;
    rearPrimaryQ= nullptr;

    headO= nullptr;
    rearO= nullptr;

}

void AVL::insert(const string& category,const string& itemname, int price) {

    addNodePrimary(category,itemname,price,&rootprimaryN);

    // balance primary

}

void AVL::addNodePrimary(const string& category,const string& itemname, int price,primaryN** ptr) {


    // if TPAVL is empty
    if ( (*ptr) == nullptr){
        // define root node of primary tree
        (*ptr) = createPrimaryNode(category);
        // connect primary and second node
        addNodeSecondary( itemname,price, &(*ptr)->rootsecondaryN);
        // balance secondary

    }
    else if( category == (*ptr)->keyCategory){
        // insert secondary node to secondary tree and balance
        addNodeSecondary( itemname,price, &(*ptr)->rootsecondaryN);

        // balance secondary , &(*ptr)->rootsecondaryN = addNodeSecondary( itemname,price, &(*ptr)->rootsecondaryN);

    }
    else if ( category < (*ptr)->keyCategory){
        addNodePrimary(category,itemname,price,&(*ptr)->leftprimaryN);
    }
    else if ( category > (*ptr)->keyCategory){
        addNodePrimary(category,itemname,price,&(*ptr)->rightprimaryN);
    }


}


void AVL::addNodeSecondary(const string& itemname,int price, AVL::secondaryN** ptr) {

    // bu ptrye eklenecek
    if ((*ptr) == nullptr){
        (*ptr) = createSecondaryNode(itemname,price);}
        // sola eklenecek
    else if ( itemname < (*ptr)->keyItem ){
        addNodeSecondary( itemname,price, &(*ptr)->leftsecondaryN );}
        // sağa eklenecek
    else if (itemname > (*ptr)->keyItem){
        addNodeSecondary( itemname,price, &(*ptr)->rightsecondaryN);}

    // eşitse ekleme yapmıyoruz belki update yaparız burda böyle bir input yok

    // balance

    // Left1 Left2 case
    if ( ( height(&(*ptr)->leftsecondaryN) - height(&(*ptr)->rightsecondaryN) ) > 1
         &&  itemname < (*ptr)->leftsecondaryN->keyItem) {
        // right rotate 1 (*ptr)
        rotateRight(&(*ptr));
    }

        // Left1 Right2 case
    else if (( height(&(*ptr)->leftsecondaryN) - height(&(*ptr)->rightsecondaryN) ) > 1
             &&  itemname > (*ptr)->leftsecondaryN->keyItem){
        // left rotate 2 (*ptr)->leftsecondaryN
        rotateLeft(&(*ptr)->leftsecondaryN);
        // right rotate 1 (*ptr)
        rotateRight(&(*ptr));

    }

        // Right1 Right2 case
    else if (( height(&(*ptr)->leftsecondaryN) - height(&(*ptr)->rightsecondaryN) ) < -1
             &&  itemname > (*ptr)->rightsecondaryN->keyItem){
        // left rotate 1 (*ptr)
        rotateLeft(&(*ptr));

    }

        // Right1 Left2 case
    else if (( height(&(*ptr)->leftsecondaryN) - height(&(*ptr)->rightsecondaryN) ) < -1
             &&  itemname < (*ptr)->rightsecondaryN->keyItem){
        // right rotate 2  (*ptr)->rightsecondaryN  ,,, (*ptr)->rightsecondaryN = rightR((*ptr)->rightsecondaryN)
        rotateRight(&(*ptr)->rightsecondaryN);
        // left rotate 1 (*ptr)
        rotateLeft(&(*ptr));


    }




}

AVL::primaryN *AVL::createPrimaryNode(string category) {

    // create primary node
    auto* nodenew = new primaryN;

    nodenew->rightprimaryN= nullptr;
    nodenew->leftprimaryN= nullptr;

    nodenew->keyCategory = std::move(category);

    nodenew->rootsecondaryN= nullptr;

    return nodenew;
}

AVL::secondaryN *AVL::createSecondaryNode(string itemname, int price) {

    // create secondary node
    auto* nodenew2 = new secondaryN;

    nodenew2->rightsecondaryN= nullptr;
    nodenew2->leftsecondaryN= nullptr;

    nodenew2->keyItem=std::move(itemname);
    nodenew2->data=price;

    return nodenew2;
}


void AVL::printAllItems() {

    printAllItemsLevelOrder(&rootprimaryN);


}

void AVL::printAllItemsLevelOrder(AVL::primaryN** ptr) {

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

void AVL::print(AVL::secondaryN** ptr) {


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

void AVL::EnqueueSecondary(secondaryN** ptr) {

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

void AVL::EnqueuePrimary(primaryN** ptr) {

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

void AVL::DequeueSecondary() {

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

void AVL::DequeuePrimary() {

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

int AVL::height(secondaryN** ptr) {

    if ( (*ptr) == nullptr){
        return 0;
    }

    int a = height( &(*ptr)->leftsecondaryN);
    int b = height( &(*ptr)->rightsecondaryN);

    int c =a>b? a:b;

    return 1+ c;

}

void AVL::rotateRight(AVL::secondaryN **ptr) {

    secondaryN* x = (*ptr)->leftsecondaryN;
    secondaryN* xright = x->rightsecondaryN;

    x->rightsecondaryN = (*ptr);
    (*ptr)->leftsecondaryN = xright;

    (*ptr) = x;

}

void AVL::rotateLeft(AVL::secondaryN **ptr) {

    secondaryN* x = (*ptr)->rightsecondaryN;
    secondaryN* xleft=x->leftsecondaryN;

    x->leftsecondaryN = (*ptr);
    (*ptr)->rightsecondaryN=xleft;

    (*ptr)=x;

}

void AVL::printAllItemsInCategory(const string& category) {

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

void AVL::printItem(const string& category, const string& itemname) {

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

AVL::primaryN *AVL::SearchPrimaryTree(const string& category) {
    return retrievePrimaryNode(category,&rootprimaryN);
}

AVL::primaryN *AVL::retrievePrimaryNode(const string& category, AVL::primaryN** ptr) {

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

AVL::secondaryN *AVL::SearchSecondaryTree(const string& itemname,secondaryN** ptr) {

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

void AVL::find(const string& category, const string& itemname) {

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

void AVL::updateData(const string& category, const string& itemname, int newPrice) {

    if ( SearchPrimaryTree(category) != nullptr){
        if (SearchSecondaryTree(itemname, & SearchPrimaryTree(category)->rootsecondaryN) != nullptr){
            SearchSecondaryTree(itemname,& SearchPrimaryTree(category)->rootsecondaryN)->data=newPrice;
        }
    }

}

void AVL::remove(const string& category, const string& itemname) {

    removePrimary(category,itemname,&rootprimaryN);

}

void AVL::removePrimary(const string& category, const string& itemname, AVL::primaryN** ptr) {

    if ( (*ptr) != nullptr){

        if ( category == (*ptr) ->keyCategory ){
            removeNode(category,itemname,&(*ptr)->rootsecondaryN);
            // balance here

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

AVL::secondaryN** AVL::minValSecondNode(secondaryN** ptr) {



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

void AVL::removeNode(const string& category, const string& itemname, AVL::secondaryN** ptr) {

    // burası yukarla birleşik olarak recursive etmesi lazım

    if ((*ptr) == nullptr){
        // do nothing
        return;
    }
        // sola eklenecek
    else if ( itemname < (*ptr)->keyItem ){
        removeNode(category,itemname,&(*ptr)->leftsecondaryN);
    }
        // sağa eklenecek
    else if (itemname > (*ptr)->keyItem){
        removeNode(category,itemname,&(*ptr)->rightsecondaryN);
    }
    else if (itemname == (*ptr)->keyItem){

        // deletion
        // only right child
        if ( (*ptr)->leftsecondaryN == nullptr && (*ptr)->rightsecondaryN != nullptr){

            secondaryN* temp = (*ptr);

            (*ptr)=temp->rightsecondaryN;
            temp->rightsecondaryN= nullptr;
            free(temp);


        }
            // only left child
        else if ((*ptr)->leftsecondaryN != nullptr && (*ptr)->rightsecondaryN == nullptr){

            secondaryN* temp = (*ptr);
            (*ptr)=temp->leftsecondaryN;
            temp->leftsecondaryN= nullptr;
            free(temp);

        }
            // two child
        else if ( (*ptr)->leftsecondaryN != nullptr && (*ptr)->rightsecondaryN != nullptr){

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
            // no child
        else if ( (*ptr)->leftsecondaryN == nullptr && (*ptr)->rightsecondaryN == nullptr ){

            secondaryN* temp = (*ptr);
            (*ptr)=nullptr;
            free(temp);

        }

    }

    // balance
    if ((*ptr) == nullptr ){
        return;
    }
        // burda solunun balance factoru nulsa nolur kontrol et
        // Left1 Left2 case
    else if ( ( height(&(*ptr)->leftsecondaryN) - height(&(*ptr)->rightsecondaryN) ) == 2
              &&  ( height(&(*ptr)->leftsecondaryN->leftsecondaryN) - height(&(*ptr)->leftsecondaryN->rightsecondaryN) ) >= 0) {
        // right rotate 1 (*ptr)
        rotateRight(&(*ptr));
    }

        // Left1 Right2 case
    else if (( height(&(*ptr)->leftsecondaryN) - height(&(*ptr)->rightsecondaryN) ) == 2
             &&  ( height(&(*ptr)->leftsecondaryN->leftsecondaryN) - height(&(*ptr)->leftsecondaryN->rightsecondaryN) ) == -1){
        // left rotate 2 (*ptr)->leftsecondaryN
        rotateLeft(&(*ptr)->leftsecondaryN);
        // right rotate 1 (*ptr)
        rotateRight(&(*ptr));

    }

        // Right1 Right2 case
    else if (( height(&(*ptr)->leftsecondaryN) - height(&(*ptr)->rightsecondaryN) ) == -2
             &&  ( height(&(*ptr)->rightsecondaryN->leftsecondaryN) - height(&(*ptr)->rightsecondaryN->rightsecondaryN) ) <= 0){
        // left rotate 1 (*ptr)
        rotateLeft(&(*ptr));

    }

        // Right1 Left2 case
    else if (( height(&(*ptr)->leftsecondaryN) - height(&(*ptr)->rightsecondaryN) ) == -2
             &&   ( height(&(*ptr)->rightsecondaryN->leftsecondaryN) - height(&(*ptr)->rightsecondaryN->rightsecondaryN) ) == 1){
        // right rotate 2  (*ptr)->rightsecondaryN  ,,, (*ptr)->rightsecondaryN = rightR((*ptr)->rightsecondaryN)
        rotateRight(&(*ptr)->rightsecondaryN);
        // left rotate 1 (*ptr)
        rotateLeft(&(*ptr));

    }

}

void AVL::PushO(string s) {

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

string AVL::PopO() {

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


















