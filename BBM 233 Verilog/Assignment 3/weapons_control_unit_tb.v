`timescale 1us/1ns

module weapons_control_unit_tb;
    reg target_locked;
    reg clk;
    reg rst;
    reg fire_command;
    wire launch_missile;

    wire [1:0] WCU_state;
    wire [3:0] remaining_missiles;

    weapons_control_unit uut(target_locked, clk, rst, fire_command, launch_missile, remaining_missiles, WCU_state);

    initial begin
        // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!
        // Please inspect the provided waveforms very carefully and try to produce the same results.
        // Make sure to use $finish statement to avoid infinite loops.
    end

    
    initial begin
        clk = 0;
        forever begin
            #5;
            clk = ~clk;
        end
    end

endmodule