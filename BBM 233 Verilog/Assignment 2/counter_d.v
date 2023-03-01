module counter_d(input reset, input clk, input mode, output [2:0] count);

    // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!

    // flip flop inputs

    wire D0,D1,D2;

// 0- Inputs hex converter

    wire notc0,notc1,notc2,notmode;

    not gate90(notc0,count[0]);
    not gate91(notc1,count[1]);
    not gate92(notc2,count[2]);
    not gate93(notmode,mode);    

// 1-first flip flop

    // 1a-mode 0 inputs , binary

    wire x;

    and gate1(x,notc0, notmode); // D0 = ~Q0 ,mode 0

    // 1b-mode 1 inputs , gray code

    wire y,y1,y2,y3;

    and gate2(y,count[2],count[1]);
    and gate3(y1,notc2,notc1);

    or gate4(y2,y,y1);

    and gate5(y3,y2,mode); // D0 = (Q2 & Q1) | (~Q2 & ~Q1) , mode 1

    // 1c-decide first flip flop , mode 0 or 1

    or gate6(D0,x,y3);

// 2-second flip flop

    // 2a-mode 0 inputs , binary

    wire z,z1,z2,z3;

    and gate7(z,notc0,count[1]);
    and gate8(z1,count[0],notc1);

    or gate9(z2,z,z1);

    and gate10(z3,z2,notmode); // D1 = (Q1 & Q0) | (~Q1 & Q0) , mode 0

    // 2b-mode 1 inputs , gray code

    wire v,v1,v2,v3;

    and gate11(v,notc2,count[0]);
    and gate12(v1,count[1],notc0);

    or gate13(v2,v,v1);

    and gate14(v3,v2,mode); // D1 = (~Q2 & Q0) | (Q1 & ~Q0) , mode 1

    // 2c-decide second flip flop , mode 0 or 1

    or gate15(D1,z3,v3);

// 3-third flip flop

    // 3a-mode 0 inputs , binary

    wire n,n1,n2,n3,n4;

    and gate16(n,count[2],notc1);
    and gate17(n1,count[2],count[1],notc0);
    and gate18(n2,notc2,count[1],count[0]);

    or gate19(n3,n,n1,n2);

    and gate20(n4,n3,notmode); // D2 = (Q2 & ~Q1) | (Q2 & Q1 & ~Q0) | (~Q2 & Q1 & Q0) , mode 0

    // 3b-mode 1 inputs , gray code

    wire m,m1,m2,m3,m4;

    and gate21(m,count[2],count[1]);
    and gate22(m1,count[2],notc1,count[0]);
    and gate23(m2,notc2,count[1],notc0);

    or gate24(m3,m,m1,m2);

    and gate25(m4,m3,mode); // D2 = (Q2 & Q1) | (Q2 & ~Q1 & Q0) | (~Q2 & Q1 & ~Q0) , mode 1

    // 3c-decide third flip flop , mode 0 or 1

    or gate26(D2,n4,m4);

// 4-call or send inputs to flip flops 
    
    dff_sync_res flip1 ( .D (D0) , .clk(clk) , .sync_reset(reset) , .Q(count[0]) );

    dff_sync_res flip2 ( .D (D1) , .clk(clk) , .sync_reset(reset) , .Q(count[1]) );

    dff_sync_res flip3 ( .D (D2) , .clk(clk) , .sync_reset(reset) , .Q(count[2]) );


endmodule