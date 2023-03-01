`timescale 1ns/1ps

module counter_tb;
    reg reset, clk, mode; 
    wire [2:0] count;
    integer i;
	
	//Comment the next line out when testing your JK flip flop implementation.
    //counter_d uut(reset, clk, mode, count);
    // Uncomment the next line to test your JK flip flop implementation.
    counter_jk c1(reset, clk, mode, count);

    initial begin
        // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!
        // Make sure to use $finish statement to avoid infinite loops.
        $dumpfile("result.vcd");
		$dumpvars;
        

        reset=1'b1;
        mode=1'b0;

        #20 reset =1'b0;

        #102 mode=1'b1;

        #100 reset =1'b1;

        #50 $finish;

    end

    initial begin

        // Generate clock
        // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!
        clk=1'b0;
        forever #5 clk = ~clk;

    end

endmodule