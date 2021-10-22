#include <stdio.h>
#include "awk_sem.h"

main() {
    int i = 0 ;
    // *** please insert proper semaphore initialization here
    int A = get_sem(".", 'A');
    int B = get_sem(".", 'B');
    int C = get_sem(".", 'C');
    do {
       // *** this is where you should place semaphore 

       P(B);
       printf("P222222222 is here\n"); i++;
       V(C);
       
       // *** this is where you should place semaphore
   
    }  while (i < 100);
}