module four_bit_adder_subtractor(A, B, subtract, Result, Cout);
    input [3:0] A;
    input [3:0] B;
    input subtract;
    output [3:0] Result;
    output Cout;

    // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!

    // 2S COMPLEMENT PART
    wire [3:0]Out2s;
    
    two_s_complement compFunc (  .In(B) , .Out(Out2s) ) ;

    // MUX PART

    wire [3:0]CoutMux; 

    four_bit_2x1_mux muxFunc ( .In_0(B) , .In_1(Out2s) , .Select(subtract) , .Out(CoutMux) );

    // 4 bit full adder part

    four_bit_rca funcRca ( .A(A) , .B(CoutMux) , .Cin(0) , .S(Result) , .Cout(Cout) );


endmodule