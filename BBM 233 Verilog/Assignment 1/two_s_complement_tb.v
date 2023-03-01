`timescale 1ns/10ps
module two_s_complement_tb;

   // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!

   reg In;
   wire Out;

   two_s_complement UUT ( .In(In) , .Out(Out));

   integer b;

   initial begin
      
      $dumpfile("2scomplement.vcd");
		$dumpvars;

      // easy 4 bit input giver implementation



      for (b=0;b<16;b=b+1) begin
				{In}=b; #10;
		end

      #10 $finish;

   end
endmodule 