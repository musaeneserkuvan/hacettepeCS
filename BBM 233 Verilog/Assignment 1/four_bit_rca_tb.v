`timescale 1 ns/10 ps
module four_bit_rca_tb;

  // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!
  reg [3:0] A,B;
  reg Cin;

  wire [3:0] S;
  wire Cout;

  four_bit_rca UUT ( .A(A) , .B(B) , .Cin(Cin) , .S(S) , .Cout(Cout) );


  integer a;
  integer b;
  integer c;

  initial begin
    
    $dumpfile("fourbitrca.vcd");
		$dumpvars;

    // theres a A and B which is 4bit , 1 bit Cin input and we need to give them inputs , so codes is below


    for (a=0;a<2;a=a+1) begin

			{Cin}=a; #10;

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