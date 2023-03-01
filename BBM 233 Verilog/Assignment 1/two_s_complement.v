module two_s_complement(In,Out);
    input [3:0] In;
    output [3:0] Out;

    // this is what i learned from BBM 231 lesson for how to 
    // get 2s complement , so basically , subtract the input
    // from 1111  and this is 1s complement 
    // after that just add 1 single bit
    assign Out = (4'b1111 - In ) + 1   ;
    
    // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!

endmodule  
