module dff_sync_res(D, clk, sync_reset, Q);
    input D;
    input clk;
    input sync_reset;
    output reg Q;

    // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!
    
    always @(posedge clk ) // this means positive edge , Rising edge of clock , initialize the below code everytime
    begin

        if(sync_reset==1'b1)
            Q <= 1'b0; 

        else 
            Q <= D;
        
    end

endmodule 