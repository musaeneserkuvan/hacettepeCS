`timescale 1ns/10ps
module four_bit_2x1_mux_tb;
	
// Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!

	reg [3:0] In_0;
	reg [3:0] In_1;
	reg Select;

	wire [3:0] Out;

	four_bit_2x1_mux UUT ( .In_0(In_0) , .In_1(In_1) , .Select(Select) , .Out(Out) );


	integer a;
	integer b;
	
	initial begin
		
		$dumpfile("mux.vcd");
		$dumpvars;



		// we are giving input numbers to in0 and In1 as they are 4bit , they can only take between 0 and 256
		// also we wanted to try them while Select is 0 and 1 so heres the easy and quick code

		for (a=0;a<2;a=a+1) begin

			{Select}=a; #10;

			for (b=0;b<256;b=b+1) begin
				{In_0,In_1}=b; #10;
			end
				
		end

		#10 $finish;

	end	
	
	
endmodule