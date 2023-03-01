`timescale 1ns/1ps
module four_bit_adder_subtractor_tb;

    // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!
    
    reg [3:0] A,B;
    reg subtract;

    wire [3:0] Result;
    wire Cout;

    four_bit_adder_subtractor UUT ( .A(A) , .B(B) , .subtract(subtract) , .Result(Result) , .Cout(Cout) );

    integer a;
    integer b;
    integer c;
        
    initial begin
        
        $dumpfile("fbitadder.vcd");
		$dumpvars;

    // same as four bit rca inputs
    // theres a A and B which is 4bit , 1 bit subtract input and we need to give them inputs , so codes is below



        for (a=0;a<2;a=a+1) begin

			{subtract}=a; #10;

			for (b=0;b<256;b=b+1) begin
				{A}=b; #10;

                for ( c=0;c<256; c=c+1) begin
                    {B}=c; #10;
                end

			end
				
		end

        #10 $finish;


    end

endmodule