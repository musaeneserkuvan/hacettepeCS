module jk_sync_res(J, K, clk, sync_reset, Q);
    input J;
    input K;
    input clk;
    input sync_reset;
    output reg Q;

    // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!

    always@ (posedge(clk))  
    begin
        if(sync_reset == 1'b1) 
            Q <= 1'b0;
        else    
            if(J == 0 && K == 0)    
                Q <= Q; 
            else if(J == 0 && K == 1)
                Q <= 1'b0;  
            else if(J == 1 && K == 0)
                Q <= 1'b1;  
            else
                Q <= ~Q;  
            
    end

endmodule