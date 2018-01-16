# Producer_Consumer_Model

## Members
JN Wang, XT Bao

## Results
The integers will be printed from 0 to the number entered when increase. And will decrease by one per time. The increase(produce resource) and decrease(consume resource) of the number will alternates randomly.

## Discussion
1. How many of each integer should you see printed?
Answer: Integers from 0 to the number entered. Twice for each(increase once, decrease once).

2. In what order should you expect to see them printed? Why?
Answer: The overall order should be sequential, such as 2 should always be produced after 1 and consumed after 1. While the increase and decrease operation should be random, because the thread is scheduled by the operating system, we do not really know the order.

3. Did your results differ from your answers in (1) and (2)? Why or why not?
Answer: Our result is the same as answers in (1) and (2). Because the answers above have considered the randomness of thread scheduling.
