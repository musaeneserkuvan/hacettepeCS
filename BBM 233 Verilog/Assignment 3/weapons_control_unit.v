`timescale 1us/1ns

module weapons_control_unit(
    input target_locked,
    input clk,
    input rst,
    input fire_command,
    output reg launch_missile,
    output [3:0] remaining_missiles,
    output [1:0] WCU_state
);

    // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!
    // You should implement the weapons_control_unit module HERE using behavioral design approach. 
    // You should read the instructions first and make sure you understand the problem completely.
    // Please inspect the provided waveforms very carefully and try to produce the same results.

endmodule