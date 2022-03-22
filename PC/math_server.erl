-module(math_server).
-export([start/0, loop/0, factorial/2]).

compute_factorial(0) -> 1;
compute_factorial(N) -> N * compute_factorial(N - 1).   


loop() ->
    receive
        {factorial, From, M} ->
            From ! {response, compute_factorial(M)},
            loop()
    end.

start() ->
    spawn(math_server, loop, []).

factorial(Server, M) ->
    Server ! {factorial, self(), M},
    receive{response, Result} -> Result 
end.