package lab7;

import lab7.code.Coins;

public class L7_MinCoin_Main {
    
    public static void main(String[] args) {
        // ex1();
        int amount = 0;
        for (amount = 0; amount < 0; amount++) { 
            System.out.println("amount " + amount + " uses " + minNumCoin(amount));
            int [] minCoinResidual = new int[amount+1];
            System.out.println("amount " + amount + " uses " + minNumCoin(amount,minCoinResidual));
        }
        fasterBy();
    }
    static void ex1() {
        for (Coins c : Coins.values()) {
            System.out.println("Coin " + c + "s are ready ");
        }
    }

    static int minNumCoin(int amount) {
        // System.out.println("call for " + amount);
        if (amount == 0) return 0; //base case

        int coinsNeeded = Integer.MAX_VALUE;
        
        int numCoin = 0;
        for (Coins c : Coins.values()) {
            if (c.value() <= amount) {
                numCoin = 1 + minNumCoin(amount - c.value());
                if (numCoin < coinsNeeded)
                    coinsNeeded = numCoin;
            }
        }
        /* equiv to below code */ 
        // int minP, minN, minD;
        // minP = minN = minD = 0;
        // if (amount >= Coins.PENNY.value()) { 
        //     minP = 1 + minNumCoin(amount - Coins.PENNY.value());
        //     if (minP < coinsNeeded)
        //         coinsNeeded = minP;
        // }
        // if (amount >= Coins.NICKEL.value()) { 
        //     minN = 1 + minNumCoin(amount - Coins.NICKEL.value());
        //     if (minN < coinsNeeded)
        //         coinsNeeded = minN;
        // }   
        // if (amount >= Coins.DIME.value()) { 
        //     minD = 1 + minNumCoin(amount - Coins.DIME.value());
        //     if (minD < coinsNeeded)
        //         coinsNeeded = minD;
        // }
        return coinsNeeded;
    }
    
    static int minNumCoin(int amount, int [] residual) {
        if (amount == 0) return 0; //base case

        int coinsNeeded = Integer.MAX_VALUE;
        
        int numCoin = 0;
        for (Coins c : Coins.values()) {
            if (c.value() <= amount) {
                if (residual[amount -  c.value()] > 0)
                    numCoin = 1 + residual[amount - c.value()];
                else
                    numCoin = 1 + minNumCoin(amount - c.value(), residual);
                if (numCoin < coinsNeeded)
                    coinsNeeded = numCoin;
            } 
        }
        residual[amount] = coinsNeeded;
        return coinsNeeded;
    }

    static void fasterBy() {
        int amount = 70;
        long time = System.currentTimeMillis();
        System.out.print("amount = " + amount + " uses " + minNumCoin(amount));
        System.out.println(" elapse time = " + (int)(System.currentTimeMillis() - time));
        
        time = System.currentTimeMillis();
        int [] residual = new int [amount + 1];
        System.out.print("amount = " + amount + " uses " + minNumCoin(amount,residual));
        System.out.println(" elapse time = " + (int)(System.currentTimeMillis() - time));
    }
}
