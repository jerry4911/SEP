#include <stdio.h>
#include "awk_sem.h"

main() {
	int i = 0 ;
    // *** Please insert proper semaphore initialization here
    int A = create_sem(".", 'A', 1);
    int B = create_sem(".", 'B', 0);
    int C = create_sem(".", 'C', 0);
    do {
       // *** this is where you should place semaphore 

       P(A);
       printf("P1111111111 is here\n"); i++;
       V(B);  
       P(A);
       V(C);
       i++;

       // *** this is where you should place semaphore
   
    }  while (i < 100) ;
}