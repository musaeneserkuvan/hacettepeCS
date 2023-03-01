`timescale 1us/1ns

module target_tracking_unit(
    input rst,
    input track_target_command,
    input clk,
    input echo,
    output reg trigger_radar_transmitter,
    output reg [13:0] distance_to_target,
    output reg target_locked,
    output [1:0] TTU_state
);

    // Your code goes here.  DO NOT change anything that is already given! Otherwise, you will not be able to pass the tests!
    // You should implement the target_tracking_unit module HERE using behavioral design approach. 
    // You should read the instructions first and make sure you understand the problem completely.
    // Please inspect the provided waveforms very carefully and try to produce the same results.

endmodule