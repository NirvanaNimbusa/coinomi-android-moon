package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;

/**
 * @author John L. Jegutanis
 */
public class MooncoinMain extends BitFamily {
    private MooncoinMain() {
        id = "mooncoin.main";

        addressHeader = 3;
        p2shHeader = 22;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        name = "Mooncoin";
        symbol = "MOON";
        uriScheme = "mooncoin";
        bip44Index = 1;
        unitExponent = 8;
        feeValue = value(100000);
        minNonDust = value(1000000);
        softDustLimit = value(10000000); // 0.1 MOON
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("Mooncoin Signed Message:\n");
    }

    private static MooncoinMain instance = new MooncoinMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
