module four_bit_2x1_mux(In_1, In_0, Select, Out);
	input [3:0] In_1;
	input [3:0] In_0;
	input Select;
	output [3:0] Out;


	assign Out=Select? In_1:In_0;

	// this code is really simple and elegant as my wife if i had one
	// anyways it means that if select 1 choose ın1  and if select 0 choose ın0 
	
	// Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!
	
endmodule