module counter_jk(input reset, input clk, input mode, output [2:0] count);

    // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!


    wire J0,K0,J1,K1,J2,K2;

// 0- Inputs hex converter
    wire notc0,notc1,notc2,notmode;

    not gate90(notc0,count[0]);
    not gate91(notc1,count[1]);
    not gate92(notc2,count[2]);
    not gate93(notmode,mode);  

// 1-first flip flop
// mode 0
    
    // J0
    wire f4;
    and gate88(f4,notc0,notmode);

    // K0
    wire f5;
    and gate89(f5,count[0],notmode);
    
// mode 1

    // J0
    wire l1,l2,l3;

    and gate7(l1,notc2,notc1,notc0);
    and gate8(l2,count[2],count[1],notc0);

    or gate9(l3,l1,l2);

    wire f2;
    and gate78(f2,l3,mode);

    // K0
    wire l4,l5,l6;

    and gate10(l4,notc2,count[1],count[0]);
    and gate11(l5,count[2],notc1,count[0]);

    or gate12(l6,l4,l5);

    wire f1;
    and gate77(f1,l6,mode);

// decide which mode to choose

    or gate660(J0,f2,f4);
    or gate679(K0,f1,f5);

// 2-second flip flop

// mode 0

    // J1
    wire x1,o1;
    and gate1(x1,notc1,count[0]); 

    and gate99(o1,x1,notmode); // J1 with mode 0

    // K1
    wire x2,o2;
    and gate2(x2,count[1],count[0]); 

    and gate100(o2,x2,notmode); // K1 with mode 0

// mode 1

    // J1
    wire l7,o3;
    and gate13(l7,notc2,notc1,count[0]);

    and gate101(o3,l7,mode);


    // K1
    wire l8,o4;
    and gate14(l8,count[2],count[1],count[0]);

    and gate102(o4,l8,mode);

// decide which mode to choose

    or gate666(J1,o3,o1);
    or gate676(K1,o4,o2);


// 3-third flip flop

// mode 0

    // J2
    wire y1,t1;
    and gate5(y1,notc2,count[1],count[0]);  

    and gate71(t1,y1,notmode);

    // K2
    wire y2,t2;
    and gate6(y2,count[2],count[1],count[0]); 

    and gate23(t2,y2,notmode);

// mode 1

    // J2
    wire l9,w1;
    and gate15(l9,notc2,count[1],notc0); 

    and gate44(w1,l9,mode);

    // K2
    wire l10,w2;
    and gate16(l10,count[2],notc1,notc0);

    and gate33(w2,l10,mode);

// decide which mode to choose

    or gate66(J2,t1,w1);
    or gate67(K2,t2,w2);

    // CALL FLIP FLOPS

    jk_sync_res flip1 ( .J(J0) , .K(K0)  ,  .clk(clk)  ,  .sync_reset(reset)  ,  .Q(count[0])  );

    jk_sync_res flip2 ( .J(J1) , .K(K1)  ,  .clk(clk)  ,  .sync_reset(reset)  ,  .Q(count[1])  );

    jk_sync_res flip3 ( .J(J2) , .K(K2)  ,  .clk(clk)  ,  .sync_reset(reset)  ,  .Q(count[2])  );

endmodule