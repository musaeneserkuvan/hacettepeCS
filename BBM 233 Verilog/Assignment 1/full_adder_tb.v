`timescale 1 ns/10 ps
module full_adder_tb;

    // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!
    reg A,B,Cin;
    wire S,Cout;

    full_adder UUT ( .A(A) , .B(B) , .Cin(Cin) , .S(S) , .Cout(Cout) );


    integer a;
    integer b;
    integer c;

    initial begin

        $dumpfile("fulladder.vcd");
		$dumpvars;

        // we need to give 3 1 bit inputs a value so here its goes



        for (a=0;a<2;a=a+1) begin

			{Cin}=a; #10;

			for (b=0;b<2;b=b+1) begin

				{A}=b; #10;

                for (c=0;c<2;c=c+1) begin
                    {B}=c; #10;

                end


			end
				
		end
    
        #10 $finish;

    end


endmodule