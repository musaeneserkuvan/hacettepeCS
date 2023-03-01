module full_adder(
    input A,
    input B,
    input Cin,
    output S,
    output Cout
);

 // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!

 // this is a simplified boolean function 

assign S = (A ^ B)^Cin;
assign Cout = (A&B) | (B&Cin) | (Cin&A);


endmodule